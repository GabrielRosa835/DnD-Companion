package dnd_companion.local_storage.validation;

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.common.command.CommandManager;
import dnd_companion.local_storage.structure.data.UnitData;

public class DataValidator extends CommandManager
{
	public <T> DataValidator validate_option(DataKey key, T option) {
		this.last_command = new ValidateOptionCommand<>(key, option).execute();
		return this;
	}
	public <T> DataValidator validate_options(DataKey key, T[] options) {
		this.last_command = null;
		return this;
	}
	public <T extends UnitData> DataValidator validate_unit(DataKey key, String unit) {
		this.last_command = new ValidateUnitCommand<T>(key, unit).execute();
		return this;
	}
}
