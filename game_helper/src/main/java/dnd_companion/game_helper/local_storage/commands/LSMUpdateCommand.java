package dnd_companion.game_helper.local_storage.commands;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import dnd_companion.game_helper.local_storage.Data;
import dnd_companion.game_helper.local_storage.DataKey;
import dnd_companion.game_helper.utils.DataBuilder;
import dnd_companion.game_helper.utils.ToolBox;

public class LSMUpdateCommand extends Command 
{
	private DataKey key;
	private Data new_data;
	
	public LSMUpdateCommand(DataKey key, Data new_data) {
		this.key = key;
		this.new_data = new_data;
	}
	
	public LSMUpdateCommand execute() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			File file = new File(DataBuilder.create_file_path(key));
			mapper.writeValue(file, new_data);
			ToolBox.print("Data update successfully");
			this.status = true;
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.status = false;
		}
		return this;
	}
}
