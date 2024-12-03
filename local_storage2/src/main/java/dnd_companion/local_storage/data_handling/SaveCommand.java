package dnd_companion.local_storage.data_handling;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import dnd_companion.local_storage.data_structure.json.templates.Data;
import dnd_companion.local_storage.data_structure.json.templates.OptionData;
import dnd_companion.local_storage.system_components.Command;
import dnd_companion.local_storage.system_components.ToolBox;

public class SaveCommand extends Command
{
	private Data data;

	private ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

	public SaveCommand(Data data) {
		this.data = data;
	}

	@Override
	public SaveCommand execute() {
		try {
			File file = new File(ToolBox.create_file_path(data));
			mapper.writeValue(file, data);
			Path path = Paths.get(file.toURI());
			String string_data;
			if (data instanceof OptionData<?>) {
				string_data = Arrays.toString(((OptionData<?>) data).options());
			} else {
				string_data = data.toString();
			}
			if (Files.exists(path)) {
				ToolBox.print("Data updated successfully: (%s) %s", data.getClass().getSimpleName(), string_data);
		    } else {
		    	ToolBox.print("Data saved successfully: (%s) %s", data.getClass().getSimpleName(), string_data);
		    }
			this.status = true;
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.status = false;
		}
		return this;
	}
}
