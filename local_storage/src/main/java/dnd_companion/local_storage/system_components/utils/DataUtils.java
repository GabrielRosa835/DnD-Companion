package dnd_companion.local_storage.system_components.utils;

import dnd_companion.local_storage.data.structure.templates.Data;
import dnd_companion.local_storage.storage_build.StorageMetadata;
import dnd_companion.local_storage.system_components.DataKey;

public class DataUtils 
{
	public static DataKey create_key (Data data) {
		return new DataKey(data.collection().toLowerCase(), data.name().toLowerCase(), data.getClass().getName());
	}
	
	public static String create_file_path(DataKey key) {
		String dir_path = StorageMetadata.directory_hierarquy.get(key.collection()).path();
		return dir_path + "\\" + key.name();
	}
	public static String create_file_path(Data data) {
		String dir_path = StorageMetadata.directory_hierarquy.get(data.collection()).path();
		return dir_path + "\\" + data.name();
	}
}
