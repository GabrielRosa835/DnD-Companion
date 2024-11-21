package dnd_companion.game_helper.local_storage.manager;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import dnd_companion.game_helper.local_storage.Data;
import dnd_companion.game_helper.local_storage.DataUtils;
import dnd_companion.game_helper.utils.Command;
import dnd_companion.game_helper.utils.LSValidations;
import dnd_companion.game_helper.utils.ToolBox;

public class LSMSaveCommand extends Command
{
	private Data data;
	
	private ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
	
	public LSMSaveCommand(Data data) {
		this.data = data;
	}
	
	public LSMSaveCommand execute() {
		try {
			File file = new File(DataUtils.create_file_path(data));
			
			if(LSValidations.check_file_existance(file.getPath())) {
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
