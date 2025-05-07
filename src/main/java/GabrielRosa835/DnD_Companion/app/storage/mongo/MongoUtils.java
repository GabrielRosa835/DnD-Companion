package app.storage.mongo;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import dev.turingcomplete.textcaseconverter.*;
import io.vavr.control.*;
import org.bson.*;

import java.util.function.*;

public interface MongoUtils {

	static <T> String collectionFor(Class<T> type) {
		var name = type.getSimpleName();
		return StandardTextCases.KEBAB_CASE.convertFrom(StandardTextCases.PASCAL_CASE, name);
	}

	static <T> String collectionFor(T entity) {
		return collectionFor(entity.getClass());
	}

	static <T> Try<String> mapEntityToJson(ObjectMapper mapper, T entity) {
		return Try.of(() -> mapper.writeValueAsString(entity));
	}

	static <T> Try<T> mapJsonToEntity(ObjectMapper mapper, String json, Class<T> type) {
		try {
			return Try.success(mapper.readValue(json, type));
		} catch (JsonProcessingException e) {
			return Try.failure(e);
		}
	}

	static Function<String, Document> queryByName() {
		return name -> new Document("name", name);
	}

	static Function<String, Document> queryById() {
		return id -> new Document("_id", id);
	}

	static <T extends MongoEntity<T>, R extends Reference<T>> Function<R, Document> queryByNameFromReference() {
		return reference -> new Document("name", reference.name());
	}

	static <T extends MongoEntity<T>, R extends Reference<T>> Function<R, Document> queryByIdFromReference() {
		return reference -> new Document("_id", reference._id());
	}
}
