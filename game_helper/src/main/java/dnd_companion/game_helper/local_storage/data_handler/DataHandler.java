package dnd_companion.game_helper.local_storage.data_handler;

import dnd_companion.game_helper.local_storage.data.structure.options.AtomicOption;
import dnd_companion.game_helper.local_storage.system_components.Data;
import dnd_companion.game_helper.local_storage.system_components.DataKey;

public class DataHandler 
{
	public static boolean save(Data data) {
		return new SaveCommand(data).execute().status();
	}
	public static Data retrieve(DataKey key) {
		return new RetrieveCommand(key).execute().result();
	}
	public static AtomicOption[] retrieve_options(String options_name) {
		return new RetrieveOptionsCommand(options_name).execute().result();
	}
}
