package dnd_companion.local_storage.validation;

import java.util.ArrayList;
import java.util.Collection;

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.structure.data.templates.AtomicUnit;

public class DataValidator
{
	public static <T> T validate_option(DataKey key, T option) {
		return new ValidateOptionCommand<>(key, option).execute().result();
	}
	public static <T> T[] validate_options(DataKey key, T[] options) {
		Collection<T> validated_options = new ArrayList<>();
		for (T option : options) {
			validated_options.add(new ValidateOptionCommand<>(key, option).execute().result());
		}
		return validated_options.toArray(options.clone());
	}
	public static <T extends AtomicUnit> T validate_unit(DataKey key, String unit) {
		return new ValidateUnitCommand<T>(key, unit).execute().result();
	}
}
