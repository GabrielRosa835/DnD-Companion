package dnd_companion.local_storage.system_components;

import dnd_companion.local_storage.data_structure.json.templates.Data;
import dnd_companion.local_storage.data_structure.json.templates.OptionData;

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

	public DataKey(String collection, String name, String type) {
		this.collection = collection;
		this.file_name = name;
		this.type = type;
	}

	public DataKey (Data data) {
		this.collection = data.collection();
		this.file_name = data.file_name();
		this.type = data.getClass().getName();
	}

	public <T, U extends OptionData<T>> DataKey (Class<U> type) {
		try {
			U type_instance = type.getConstructor().newInstance();
			this.collection = type_instance.collection();
			this.file_name = type_instance.file_name();
			this.type = type.getName();
		} catch (Exception e) {
			e.printStackTrace();
			this.collection = null;
			this.file_name = null;
			this.type = null;
		}
	}

	@Override
	public DataKey clone() {
		return new DataKey(this.collection, this.file_name, this.type);
	}
}
