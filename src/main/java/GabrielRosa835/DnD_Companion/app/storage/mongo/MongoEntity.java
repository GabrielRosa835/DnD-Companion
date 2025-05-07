package app.storage.mongo;

import org.bson.types.*;

public interface MongoEntity<T extends MongoEntity<T>> {
	String _id();
	String name();
	T with_id(String id);
}
