package dnd_companion.archives.local_storage.handling;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import dnd_companion.archives.local_storage.structure.models.Data;
import dnd_companion.archives.local_storage.tools.DataKey;
import dnd_companion.common.Command;
import dnd_companion.common.exceptions.DataAlreadyExistsException;

public class SaveCommand extends Command<Data>
{
	private final Data data;
	private final DataKey key;

	public SaveCommand(Data data) {
		this.data = data;
		this.key = new DataKey(data);
		this.message = String.format("Failed to save data: %s", this.key.toString());
	}

	@Override protected void code()	throws IOException, DataAlreadyExistsException {
		ObjectMapper mapper = new ObjectMapper()
				.enable(SerializationFeature.INDENT_OUTPUT)
				.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		File file = new File(Data.path(data));
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
