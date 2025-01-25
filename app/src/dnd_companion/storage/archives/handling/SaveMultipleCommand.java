package dnd_companion.storage.archives.handling;

import java.util.Arrays;

import javax.xml.crypto.Data;

import dnd_companion.archives.local_storage.tools.DataKey;
import dnd_companion.common.Command;

public class SaveMultipleCommand extends Command<Data[]>
{
	private final DataHandler handler = new DataHandler();

	private final Data[] data_group;

	private final DataKey[] keys;

	public SaveMultipleCommand(Data[] data_group) {
		this.data_group = data_group;
		this.keys = Arrays.stream(data_group).map(data -> new DataKey(data)).toArray(DataKey[]::new);
		this.message = "Failed to save the data group: " + Arrays.toString(this.keys);
	}

	@Override public void code() {
		for (Data data : data_group) {
			handler.save(data);
		}
		this.result = data_group;
		this.message = "Data group saved successfully: " + Arrays.toString(this.keys);
	}
}
