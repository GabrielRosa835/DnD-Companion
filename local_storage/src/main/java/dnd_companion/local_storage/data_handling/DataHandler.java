package dnd_companion.local_storage.data_handling;

import java.util.Arrays;

import dnd_companion.local_storage.data.structure.templates.AtomicOption;
import dnd_companion.local_storage.data.structure.templates.AtomicUnit;
import dnd_companion.local_storage.data.structure.templates.Data;
import dnd_companion.local_storage.system_components.DataKey;

public class DataHandler 
{
	public static boolean save(Data data) {
		return new SaveCommand(data).execute().status();
	}
	public static Data retrieve(DataKey key) {
		return new RetrieveDataCommand(key).execute().result();
	}
	public static boolean exists(DataKey key) {
		return new RetrieveDataCommand(key).execute().status();
	}
	public static AtomicOption[] retrieve_options(String option_group) {
		return new RetrieveOptionsCommand(option_group).execute().result();
	}
	public static boolean exists_option(AtomicOption option) {
		AtomicOption[] options = new RetrieveOptionsCommand(option.group()).execute().result();
		return Arrays.asList(options).contains(option);
	}
	public static AtomicUnit[] retrieve_units(String unit_group) {
		return new RetrieveUnitsCommand(unit_group).execute().result();
	}
}
