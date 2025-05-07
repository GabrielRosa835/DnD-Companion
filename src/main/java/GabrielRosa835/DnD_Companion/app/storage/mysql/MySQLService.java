package app.storage.mysql;

import io.vavr.control.*;

import java.util.*;

public class MySQLService {

	public <T> List<Try<T>> save(List<T> entities) {
		return null;
	}

	public <T> Try<T> retrieve(String name) {
		return null;
	}

	public <T> List<Try<T>> retrieve(List<String> references) {
		return null;
	}

	public List<Try<Class<?>>> createTables(List<Class<?>> types) {
		return null;
	}

	public List<Try<Class<?>>> deleteCollections(List<Class<?>> types) {
		return null;
	}

	public boolean clearDatabase() {
		return false;
	}
}
