package dnd_companion.local_storage.common;

import java.lang.reflect.InvocationTargetException;

import dnd_companion.local_storage.models.data.Data;

public class DataKey
{
	private String collection;
	public String collection() {return this.collection;}

	private String file_name;
	public String file_name() {return this.file_name;}

	private Class<? extends Data> type;
	public Class<? extends Data> type() {return this.type;}

	public DataKey(String collection, String file_name, Class<? extends Data> type) {
		this.collection = ToolBox.to_snake_case(collection);
		this.file_name = ToolBox.to_snake_case(file_name);
		this.type = type;
	}
	public DataKey() {
		this(null, null, null);
	}
	public DataKey(Data data) {
		this(data.collection(), data.file_name(), data.getClass());
	}
	public DataKey(String file_name, Class<? extends Data> type) 
		throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException 
	{
		this(type.getConstructor().newInstance().collection(), file_name, type);
	}
	
	@Override public String toString() {
		return String.format("DataKey[collection=%s, name=%s, type=%s]",
				this.collection, this.file_name, this.type.getSimpleName());
	}

	@Override
	public DataKey clone() {
		return new DataKey(this.collection, this.file_name, this.type);
	}
}
