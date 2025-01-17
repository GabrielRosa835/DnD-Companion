package dnd_companion.archives.local_storage.tools;

import dnd_companion.archives.local_storage.handling.DataHandler;
import dnd_companion.archives.local_storage.structure.models.Data;
import dnd_companion.common.Command;
import dnd_companion.common.exceptions.DataNotFoundException;

public class ValidateDataCommand extends Command<Data>
{
	private final Data data;
	private final DataKey key;
	
	public ValidateDataCommand(Data data) {
		this.data = data;
		this.key = new DataKey(data);
		this.message = String.format("Failed to validate data: %s", this.key.toString());
	}

	public void code() throws DataNotFoundException {
		Data retrieved_data = new DataHandler().retrieve(this.key).result();
		if (!data.equals(retrieved_data)) {
			throw new DataNotFoundException(String.format("Failed to retrieve data: %s", this.key.toString()));
		}
		this.result = data;
		this.message = String.format("Data validated successfully: %s", this.key.toString());
	}
}
