package dnd_companion.game_helper.local_storage.manager;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import dnd_companion.game_helper.local_storage.CollectionClassMap;
import dnd_companion.game_helper.local_storage.Data;
import dnd_companion.game_helper.local_storage.DataUtils;
import dnd_companion.game_helper.local_storage.DataKey;
import dnd_companion.game_helper.utils.Command;
import dnd_companion.game_helper.utils.ToolBox;

public class LSMRetrieveCommand extends Command
{
	private DataKey key;
	
	private Data result;
	public Data result() {return this.result;}
	
	private ObjectMapper mapper = new ObjectMapper();
	
	public LSMRetrieveCommand(DataKey key) {
		this.key = key;
		this.result = null;
	}
	
	public LSMRetrieveCommand execute() {
		try {
			File file = new File(DataUtils.create_file_path(key));
			this.result = (Data) mapper.readValue(file, CollectionClassMap.mapping().get(key.collection()));
			ToolBox.print("Data retrieved successfully");
			this.status = true;
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.status = false;
		}
		return this;
	}
}
