package dnd_companion.local_storage.common;

import dnd_companion.local_storage.structure.data.Data;

public class DataKey
{
	private String collection;
	public String collection() {return this.collection;}

	private String file_name;
	public String file_name() {return this.file_name;}

	private String type;
	public String type() {return this.type;}

	@Override public String toString() {
		return String.format("DataKey[collection=%s, name=%s, type=%s]",
				this.collection, this.file_name, ToolBox.get_simple_name_from_full(this.type));
	}

	public DataKey() {
		this.collection = null;
		this.file_name = null;
		this.type = null;
	}

	public DataKey(String collection, String file_name, String type) {
		this.collection = ToolBox.to_snake_case(collection);
		this.file_name = ToolBox.to_snake_case(file_name);
		this.type = type;
	}

	public DataKey (Data data) {
		this.collection = data.collection();
		this.file_name = data.file_name();
		this.type = data.getClass().getName();
	}

	@Override
	public DataKey clone() {
		return new DataKey(this.collection, this.file_name, this.type);
	}
}
