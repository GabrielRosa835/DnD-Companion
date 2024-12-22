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

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.common.exceptions.DataNotFoundException;
import dnd_companion.local_storage.models.common.Command;
import dnd_companion.local_storage.models.data.Data;

public class UpdateCommand extends Command<Data>
{
	private final Data data;
	private final DataKey key;

	public UpdateCommand(Data data) {
		this.data = data;
		this.key = new DataKey(data);
		this.message = String.format("Failed to update data: %s", this.key.toString());
	}
	
	@Override public void code() throws DataNotFoundException, StreamWriteException, DatabindException, IOException {
		ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
		File file = new File(ToolBox.create_file_path(data));
		Path path = Paths.get(file.toURI());
		if (!Files.exists(path)) {
			throw new DataNotFoundException(
					String.format("Failed to update data: it doesn't exist (%s)", this.key.toString()));
		}
		mapper.writeValue(file, data);
		this.result = data;
		this.message = String.format("Data updated successfully: %s", this.key.toString());
	}
}
