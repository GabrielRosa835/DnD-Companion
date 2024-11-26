package dnd_companion.local_storage.data_handling;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import dnd_companion.local_storage.data.structure.templates.Data;
import dnd_companion.local_storage.system_components.Command;
import dnd_companion.local_storage.system_components.utils.DataUtils;
import dnd_companion.local_storage.system_components.utils.Validations;
import dnd_companion.local_storage.system_components.utils.ToolBox;

public class SaveCommand extends Command
{
	private Data data;
	
	private ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
	
	public SaveCommand(Data data) {
		this.data = data;
	}
	
	public SaveCommand execute() {
		try {
			File file = new File(DataUtils.create_file_path(data));
			
			if(Validations.check_file_existance(file.getPath())) {
				mapper.writeValue(file, data);
				ToolBox.print("Data updated successfully");
			} else {
				mapper.writeValue(file, data);
				ToolBox.print("Data saved successfully");
			}
			
			this.status = true;
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.status = false;
		}
		return this;
	}
}
