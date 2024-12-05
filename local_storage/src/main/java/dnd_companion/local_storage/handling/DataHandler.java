package dnd_companion.local_storage.handling;

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.structure.data.templates.Data;

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
