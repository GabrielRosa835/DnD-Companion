package dnd_companion.local_storage.system_components;

import dnd_companion.local_storage.data.structure.templates.Data;

public record DataKey (String collection, String name) {
	public DataKey (Data data) {
		this(data.collection(), data.name());
	}
}
