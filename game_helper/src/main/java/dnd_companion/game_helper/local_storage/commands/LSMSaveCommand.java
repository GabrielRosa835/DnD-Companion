package dnd_companion.game_helper.local_storage.commands;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

import dnd_companion.game_helper.local_storage.Data;
import dnd_companion.game_helper.utils.DataBuilder;
import dnd_companion.game_helper.utils.ToolBox;

public class LSMSaveCommand extends Command
{
	private Data data;
	
	public LSMSaveCommand(Data data) {
		this.data = data;
	}
	
	public LSMSaveCommand execute() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			File file = new File(DataBuilder.create_file_path(data));
			mapper.writeValue(file, data);
			ToolBox.print("Data saved successfully");
			this.status = true;
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.status = false;
		}
		return this;
	}
}
