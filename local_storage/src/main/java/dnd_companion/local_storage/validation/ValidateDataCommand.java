package dnd_companion.local_storage.validation;

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.common.command.Command;
import dnd_companion.local_storage.common.exceptions.DataNotFoundException;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.data.Data;

public class ValidateDataCommand extends Command<ValidateDataCommand, Data>
{
	private final Data data;
	private final DataKey key;
	
	public ValidateDataCommand(Data data) {
		this.data = data;
		this.key = new DataKey(data);
		this.message = String.format("Failed to validate data: %s", this.key.toString());
	}

	public void code() throws DataNotFoundException {
		Data retrieved_data = (Data) new DataHandler().retrieve(this.key).result();
		if (!data.equals(retrieved_data)) {
			throw new DataNotFoundException(String.format("Failed to retrieve data: %s", this.key.toString()));
		}
		this.result = data;
		this.message = String.format("Data validated successfully: %s", this.key.toString());
	}
}
