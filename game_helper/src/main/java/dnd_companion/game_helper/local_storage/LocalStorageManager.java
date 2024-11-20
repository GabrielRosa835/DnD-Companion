package dnd_companion.game_helper.local_storage;

import dnd_companion.game_helper.local_storage.commands.*;

public class LocalStorageManager
{
	public static boolean save(Data data) {
		return new LSMSaveCommand(data).execute().status();
	}
	public static Data retrieve(DataKey key) {
		return new LSMRetrieveCommand(key).execute().result();
	}
	public static boolean update(DataKey key, Data new_data) {
		return new LSMUpdateCommand(key, new_data).execute().status();
	}
}