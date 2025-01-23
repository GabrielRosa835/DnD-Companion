package dnd_companion.storage.archives.handling;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import dnd_companion.archives.local_storage.structure.models.Data;
import dnd_companion.archives.local_storage.tools.DataKey;
import dnd_companion.common.Command;
import dnd_companion.common.exceptions.DataNotFoundException;

public class RetrieveCommand extends Command<Data>
{
	private final DataKey key;

	public RetrieveCommand(DataKey key) {
		this.key = key;
		this.message = "Failed to retrieved data: " + key.toString();
	}

	@Override public void code() throws IOException, DataNotFoundException {
		ObjectReader reader = new ObjectMapper().readerFor(key.collection().type());
		File file = new File(key.collection().path() + File.separator + key.file_name());
		Data data = reader.readValue(file);
		if (data == null) {
			throw new DataNotFoundException(String.format("No data found for key %s", key.toString()));
		}
		this.result = data;
		this.message = "Data retrieved successfully: " + key.toString();
	}
}
