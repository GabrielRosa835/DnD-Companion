package dnd_companion.local_storage.handling.commands;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.common.command.Command;
import dnd_companion.local_storage.common.exceptions.DataNotFoundException;
import dnd_companion.local_storage.structure.data.Data;

public class RetrieveDataCommand<T extends Data> extends Command<RetrieveDataCommand<T>, Data>
{
	private final DataKey key;

	public RetrieveDataCommand(DataKey key) {
		this.key = key;
		this.message = String.format("Failed to retrieved data: %s", key.toString());
	}

	@Override public void code() throws IOException, DataNotFoundException, ClassNotFoundException {
		ObjectReader reader = new ObjectMapper().readerFor(Class.forName(key.type()));
		File file = new File(ToolBox.create_file_path(key));
		T data = reader.readValue(file);
		if (data == null) {
			throw new DataNotFoundException(String.format("No data found for key %s", key.toString()));
		}
		this.result = data;
		this.message = String.format("Data retrieved successfully: %s", key.toString());
	}
}
