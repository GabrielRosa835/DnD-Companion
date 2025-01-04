package dnd_companion.local_storage.handling;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import dnd_companion.common.Command;
import dnd_companion.common.exceptions.DataNotFoundException;
import dnd_companion.local_storage.structure.models.Data;
import dnd_companion.local_storage.tools.DataKey;

public class UpdateCommand extends Command<Data>
{
	private final Data data;
	private final DataKey key;

	public UpdateCommand(Data data) {
		this.data = data;
		this.key = new DataKey(data);
		this.message = String.format("Failed to update data: %s", this.key.toString());
	}
	
	@Override public void code() throws DataNotFoundException, IOException {
		ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
		File file = new File(Data.path(data));
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
