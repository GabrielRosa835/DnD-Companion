package dnd_companion.local_storage.handling.commands;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.common.command.Command;
import dnd_companion.local_storage.structure.data.Data;

public class SaveCommand extends Command<Data>
{
	private final Data data;

	private final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

	public SaveCommand(Data data) {
		this.data = data;
	}

	@Override
	public SaveCommand execute() {
		try {
			File file = new File(ToolBox.create_file_path(data));
			mapper.writeValue(file, data);
			Path path = Paths.get(file.toURI());
			String success_message;
			if (Files.exists(path)) {
				success_message = "updated";
		    } else {
		    	success_message = "saved";
		    }
			this.status = true;
			this.result = data;
			this.message = String.format("Data %s successfully: (%s) %s", 
					success_message, data.getClass().getSimpleName(), data.toString());
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.status = false;
			this.result = null;
			this.message = String.format("Failed to save or upload (%s) %s",
					data.getClass().getSimpleName(), data.toString());
		}
		return this;
	}
}
