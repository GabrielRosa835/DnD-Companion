package dnd_companion.game_helper.local_storage.manager;

import dnd_companion.game_helper.local_storage.Data;
import dnd_companion.game_helper.local_storage.DataKey;

public class LocalStorageManager
{
	public static boolean save(Data data) {
		return new LSMSaveCommand(data).execute().status();
	}
	public static Data retrieve(DataKey key) {
		return new LSMRetrieveCommand(key).execute().result();
	}
}