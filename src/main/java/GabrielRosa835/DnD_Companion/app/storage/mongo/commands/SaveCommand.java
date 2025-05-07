package app.storage.mongo.commands;

import app.storage.mongo.*;
import com.fasterxml.jackson.databind.*;
import io.vavr.control.*;
import lombok.*;
import org.bson.*;
import org.springframework.data.mongodb.core.*;

import java.util.*;

import static app.storage.mongo.MongoUtils.*;

@AllArgsConstructor(staticName = "with")
public class SaveCommand<T extends MongoEntity<T>> {

	private MongoService database;
	private MongoTemplate template;
	private ObjectMapper mapper;

	private List<T> entities;

	public List<Try<T>> execute() {
		if (entities.isEmpty()) {
			return List.of(Try.failure(new RuntimeException("No entity to save in " + entities)));
		}
		var type = entities.getFirst().getClass();
		if (!template.collectionExists(type)) {
			return List.of(Try.failure(new RuntimeException("Collection for " + type.getSimpleName() + " doesn't exist")));
		}

		var documents = entities.stream()
				.map(entity -> Try.of(() -> mapper.writeValueAsString(entity)))
				.map(Try::getOrNull)
				.filter(Objects::nonNull)
				.map(Document::parse)
				.peek(document -> document.remove("_id"))
				.toList();

		template.getCollection(template.getCollectionName(type)).insertMany(documents);

		List<Reference<T>> references = entities.stream().map(Reference::of).toList();
		List<Try<T>> results = database.retrieve(references, queryByNameFromReference());

		return results;
	}
}
