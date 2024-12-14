package dnd_companion.local_storage.validation;

import dnd_companion.local_storage.common.CommandManager;
import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.structure.data.Data;
import dnd_companion.local_storage.structure.data.system.units.UnitProperties;

public class DataValidator extends CommandManager
{
	public ValidateDataCommand validate(Data data) {
		return new ValidateDataCommand(data).execute();
	}
	public <T extends UnitProperties & Data> ValidateUnitCommand<T> validate_unit(DataKey key, String unit) {
		return new ValidateUnitCommand<T>(key, unit).execute();
	}
}
