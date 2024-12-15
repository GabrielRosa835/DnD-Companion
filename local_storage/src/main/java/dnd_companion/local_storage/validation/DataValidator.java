package dnd_companion.local_storage.validation;

import dnd_companion.local_storage.common.CommandManager;
import dnd_companion.local_storage.structure.data.Data;

public class DataValidator extends CommandManager
{
	public ValidateDataCommand validate(Data data) {
		return new ValidateDataCommand(data).execute();
	}
}
