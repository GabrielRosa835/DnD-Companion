package dnd_companion.local_storage.data_validation;

import java.util.ArrayList;
import java.util.Collection;

import dnd_companion.local_storage.system_components.DataKey;
import dnd_companion.local_storage.system_components.exceptions.InvalidOptionException;

public class DataValidator 
{
	public static <T> T validate_option(DataKey key, T option) throws Exception {
		try {
			return new ValidateOptionCommand<T>(key, option).execute().result();			
		} catch (InvalidOptionException e) {
			throw new Exception(e.getMessage());
		}
	}
	public static <T> T[] validate_options(DataKey key, T[] options) throws Exception {
		try {
			Collection<T> validated_options = new ArrayList<T>();
			for (T option : options) {
				validated_options.add(new ValidateOptionCommand<T>(key, option).execute().result());
			}
			return validated_options.toArray(options.clone());			
		} catch (InvalidOptionException e) {
			throw new Exception(e.getMessage());
		}
	}
}
