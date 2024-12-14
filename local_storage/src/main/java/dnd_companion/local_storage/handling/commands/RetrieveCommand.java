package dnd_companion.local_storage.handling.commands;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import dnd_companion.local_storage.common.Command;
import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.common.exceptions.DataNotFoundException;
import dnd_companion.local_storage.structure.data.Data;

public class RetrieveCommand extends Command<Data>
{
	private final DataKey key;

	public RetrieveCommand(DataKey key) {
		this.key = key;
		this.message = "Failed to retrieved data: %s" + key.toString();
	}

	@Override public void code() throws IOException, DataNotFoundException, ClassNotFoundException {
		ObjectReader reader = new ObjectMapper().readerFor(key.type());
		File file = new File(ToolBox.create_file_path(key));
		Data data = reader.readValue(file);
		if (data == null) {
			throw new DataNotFoundException(String.format("No data found for key %s", key.toString()));
		}
		this.result = data;
		this.message = "Data retrieved successfully: %s" + key.toString();
	}
}
