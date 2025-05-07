package app.storage.mongo;

import app.storage.mongo.commands.*;
import com.fasterxml.jackson.databind.*;
import io.vavr.control.*;
import org.bson.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.mongodb.core.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.function.*;

@Service
public class MongoService {

	@Autowired
	private MongoTemplate template;
	@Autowired
	private ObjectMapper mapper;

	public <T extends MongoEntity<T>> List<Try<T>> save(List<T> entities) {
		return SaveCommand.with(this, template, mapper, entities).execute();
	}

	public <T extends MongoEntity<T>, R extends Reference<T>> Try<T> retrieve(
			R reference, Function<R, Document> queryGenerator
	) {
		return RetrieveCommand.<T, R>with(template, mapper, List.of(reference), queryGenerator).execute().getFirst();
	}

	public <T extends MongoEntity<T>, R extends Reference<T>> List<Try<T>> retrieve(
			List<R> references, Function<R, Document> queryGenerator
	) {
		return RetrieveCommand.<T, R>with(template, mapper, references, queryGenerator).execute();
	}

	public List<Class<?>> createCollections(List<Class<?>> types) {
		return types.stream()
				.filter(type -> !template.collectionExists(type))
				.peek(template::createCollection)
				.toList();
	}

	public <T extends MongoEntity<T>> List<Class<? extends MongoEntity<T>>> deleteCollections(List<Class<? extends MongoEntity<T>>> types) {
		return types.stream()
				.filter(template::collectionExists)
				.peek(template::dropCollection)
				.toList();
	}

	public boolean clearDatabase() {
		template.getCollectionNames().forEach(template::dropCollection);
		return template.getCollectionNames().isEmpty();
	}
}
