package dnd_companion.game_helper.local_storage.commands;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import dnd_companion.game_helper.local_storage.CollectionsMap;
import dnd_companion.game_helper.local_storage.Data;
import dnd_companion.game_helper.local_storage.DataKey;
import dnd_companion.game_helper.utils.DataBuilder;
import dnd_companion.game_helper.utils.ToolBox;

public class LSMRetrieveCommand extends Command
{
	private DataKey key;
	
	private Data result;
	public Data result() {return this.result;}
	
	public LSMRetrieveCommand(DataKey key) {
		this.key = key;
		this.result = null;
	}
	
	public LSMRetrieveCommand execute() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			File file = new File(DataBuilder.create_file_path(key));
			this.result = (Data) mapper.readValue(file, CollectionsMap.mapping().get(key.collection()));
			ToolBox.print("Data retrieved successfully");
			this.status = true;
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.status = false;
		}
		return this;
	}
}
