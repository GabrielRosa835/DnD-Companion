package dnd_companion.local_storage.data_validation;

import java.util.Arrays;
import java.util.Optional;

import dnd_companion.local_storage.data_handling.DataHandler;
import dnd_companion.local_storage.data_structure.json.templates.AtomicUnit;
import dnd_companion.local_storage.system_components.Command;
import dnd_companion.local_storage.system_components.DataKey;
import dnd_companion.local_storage.system_components.ToolBox;
import dnd_companion.local_storage.system_components.exceptions.InvalidOptionException;

public class ValidateUnitCommand<T extends AtomicUnit> extends Command
{
	private DataKey key;
	private String unit;

	private T result;
	public T result() {return this.result;}

	public ValidateUnitCommand(DataKey key, String unit) {
		this.key = key;
		this.unit = unit;
	}

	@Override
	public ValidateUnitCommand<T> execute() {
		try {
			T[] options = DataHandler.retrieve_options(key);
			Optional<T> optional = Arrays.stream(options).filter(option ->
					option.name().equals(ToolBox.to_snake_case(unit)) ||
					option.abbreviation().equals(unit.toUpperCase()))
					.findFirst();
			if (optional.isEmpty()) {
				throw new InvalidOptionException(String.format("Not a valid unit: %s", unit));
			}
			this.result = optional.get();
			this.status = true;
			this.message = "Unit validated successfully: " + this.result.toString();
		} catch (Exception e) {
			this.result = null;
			this.status = false;
			this.message = "Something went wrong while validating unit";
			e.printStackTrace();
		}
		return this;
	}
}
