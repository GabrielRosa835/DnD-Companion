package dnd_companion.game_helper.local_storage.data_handling;

import java.util.Arrays;

import dnd_companion.game_helper.local_storage.data.structure.templates.AtomicOption;
import dnd_companion.game_helper.local_storage.data.structure.templates.Data;
import dnd_companion.game_helper.local_storage.system_components.DataKey;

public class DataHandler 
{
	public static boolean save(Data data) {
		return new SaveCommand(data).execute().status();
	}
	public static Data retrieve(DataKey key) {
		return new RetrieveCommand(key).execute().result();
	}
	public static boolean exists(DataKey key) {
		return new RetrieveCommand(key).execute().status();
	}
	public static AtomicOption[] retrieve_options(String option_group) {
		return new RetrieveOptionsCommand(option_group).execute().result();
	}
	public static boolean exists_options(AtomicOption option) {
		AtomicOption[] options = new RetrieveOptionsCommand(option.group()).execute().result();
		return Arrays.asList(options).contains(option);
	}
}
