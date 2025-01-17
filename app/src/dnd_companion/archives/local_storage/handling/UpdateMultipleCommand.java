package dnd_companion.archives.local_storage.handling;

import java.util.Arrays;

import dnd_companion.archives.local_storage.structure.models.Data;
import dnd_companion.archives.local_storage.tools.DataKey;
import dnd_companion.common.Command;

public class UpdateMultipleCommand extends Command<Data[]>
{
	private final Data[] data_collection;
	private final DataKey[] keys;
			
	public UpdateMultipleCommand(Data[] data_collection) {
		this.data_collection = data_collection;
		this.keys = Arrays.stream(data_collection).map(data -> new DataKey(data)).toArray(DataKey[]::new);
		this.message = String.format("Failed to save the data collection: %s", Arrays.toString(this.keys));
	}

	@Override public void code() {
		DataHandler data_handler = new DataHandler();
		for (Data data : data_collection) {
			data_handler.update(data);
		}
		this.result = data_collection;
		this.message = String.format("Data collection saved successfully: %s", Arrays.toString(this.keys));
	}
}
