package app.storage.mongo.commands;

import app.storage.mongo.*;
import com.fasterxml.jackson.databind.*;
import io.vavr.control.*;
import lombok.*;
import org.bson.*;
import org.springframework.data.mongodb.core.*;

import java.util.*;
import java.util.function.*;

@AllArgsConstructor(staticName = "with")
public class RetrieveCommand<T extends MongoEntity<T>, R extends Reference<T>> {

	private MongoTemplate template;
	private ObjectMapper mapper;

	private List<R> references;
	private Function<R, Document> queryGenerator;

	public List<Try<T>> execute() {
		if (references.isEmpty()) {
			return List.of(Try.failure(new RuntimeException("List of references is empty")));
		}
		var type = references.getFirst().type();
		if (!template.collectionExists(type)) {
			return List.of(Try.failure(new RuntimeException("Collection for " + type.getSimpleName() + " doesn't exist")));
		}
		return references.stream()
				.map(this::mapReference)
				.toList();
	}

	private Try<T> mapReference(R reference) {
		var type = reference.type();
		var mongoCollection = template.getCollection(template.getCollectionName(type));
		return Try.success(reference)
				.map(queryGenerator)
				.flatMap(q ->
						Option.of(mongoCollection.find(q).first())
						.toTry(() -> new RuntimeException("Couldn't find document " + q)))
				.map(Document::toJson)
				.flatMap(json -> Try.of(() -> mapper.readValue(json, type)));
	}

}
