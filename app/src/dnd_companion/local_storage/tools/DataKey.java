package dnd_companion.local_storage.tools;

import dnd_companion.common.metadata.CollectionREF;
import dnd_companion.local_storage.structure.models.Data;

public class DataKey
{
	private CollectionREF collection;
	public CollectionREF collection() {return this.collection;}

	private String file_name;
	public String file_name() {return this.file_name;}

	public DataKey(CollectionREF collection, String file_name) {
		this.collection = collection;
		this.file_name = file_name;
	}
	public DataKey(Data data) {
		this(data.collection(), data.file_name());
	}
	
	@Override public String toString() {
		return String.format("DataKey[collection=%s, file_name=%s]", this.collection.toString(), this.file_name);
	}
}
