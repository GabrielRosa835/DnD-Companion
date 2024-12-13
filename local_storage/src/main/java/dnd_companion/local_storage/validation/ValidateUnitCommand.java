package dnd_companion.local_storage.validation;

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.common.command.Command;
import dnd_companion.local_storage.common.exceptions.InvalidDataException;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.data.Data;
import dnd_companion.local_storage.structure.data.system.units.UnitProperties;

public class ValidateUnitCommand<T extends Data & UnitProperties> extends Command<ValidateUnitCommand<T>, T>
{
	private final DataKey key;
	private final String unit_value;

	public ValidateUnitCommand(DataKey key, String unit_value) {
		this.key = key;
		this.unit_value = unit_value;
		this.message = "Failed to validate unit: " + unit_value;
	}

	@Override public void code() throws InvalidDataException {
		@SuppressWarnings("unchecked")
		T retrieved_data = (T) new DataHandler().retrieve(key).result();
		if (
			!this.unit_value.equals(retrieved_data.name()) && 
			!this.unit_value.equals(retrieved_data.abbreviation())
		){
			throw new InvalidDataException("Not a valid unit: " + this.unit_value);
		}
		this.result = retrieved_data;
		this.message = "Unit validated successfully: " + this.result.toString();
	}
}
