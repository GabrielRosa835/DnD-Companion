package dnd_companion.local_storage.system_components.utils;

import dnd_companion.local_storage.data.structure.templates.Data;
import dnd_companion.local_storage.system_components.DataKey;

public class DataUtils 
{
	public static DataKey create_key (Data data) {
		return new DataKey(data.collection().toLowerCase(), data.name().toLowerCase());
	}
	
	public static String create_file_path(DataKey key) {
		return String.format("data/%s/%s.json", key.collection(), ToolBox.to_snake_case(key.name()));
	}
	public static String create_file_path(Data data) {
		return String.format("data/%s/%s.json", data.collection(), ToolBox.to_snake_case(data.name()));
	}
}
