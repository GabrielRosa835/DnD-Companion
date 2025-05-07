package app.storage.mongo;

import lombok.*;
import org.bson.types.*;

@With
public record Reference<T extends MongoEntity<T>>(
		String _id,
		String name,
		Class<T> type
) implements MongoEntity<Reference<T>> {
	@SuppressWarnings("unchecked")
	public static <T extends MongoEntity<T>> Reference<T> of(T value) {
		return new Reference<>(value._id(), value.name(), (Class<T>) value.getClass());
	}

	public static <T extends MongoEntity<T>> Reference<T> of(String id, String name, Class<T> type) {
		return new Reference<>(id, name, type);
	}
}
