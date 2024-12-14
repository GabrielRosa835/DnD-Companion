package dnd_companion.local_storage.handling.commands;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import dnd_companion.local_storage.common.Command;
import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.common.exceptions.DataAlreadyExistsException;
import dnd_companion.local_storage.structure.data.Data;

public class SaveCommand extends Command<Data>
{
	private final Data data;
	private final DataKey key;

	public SaveCommand(Data data) {
		this.data = data;
		this.key = new DataKey(data);
		this.message = String.format("Failed to save data: %s", this.key.toString());
	}

	@Override protected void code()	throws StreamWriteException, DatabindException, IOException, DataAlreadyExistsException {
		ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
		File file = new File(ToolBox.create_file_path(data));
		Path path = Paths.get(file.toURI());
		if (Files.exists(path)) {
			throw new DataAlreadyExistsException(
					String.format("Failed to save data: it already exists (%s)", this.key.toString()));
		}
		mapper.writeValue(file, data);
		this.result = data;
		this.message = String.format("Data saved successfully: %s", this.key.toString());
	}
}
