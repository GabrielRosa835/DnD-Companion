package dnd_companion.local_storage.data_handling;

import dnd_companion.local_storage.data.structure.templates.Data;
import dnd_companion.local_storage.system_components.DataKey;

public class DataHandler 
{
	public static boolean save(Data data) {
		return new SaveCommand(data).execute().status();
	}
	public static <T extends Data> Data retrieve(DataKey key) {
		return new RetrieveDataCommand<T>(key).execute().result();
	}
	public static <T extends Data> boolean exists(DataKey key) {
		return new RetrieveDataCommand<T>(key).execute().status();
	}
	public static <T> T[] retrieve_options(DataKey key) {
		return new RetrieveOptionsCommand<T>(key).execute().result();
	}
}
