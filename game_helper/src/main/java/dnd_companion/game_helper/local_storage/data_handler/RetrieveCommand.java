package dnd_companion.game_helper.local_storage.data_handler;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import dnd_companion.game_helper.local_storage.system_components.CollectionClassMap;
import dnd_companion.game_helper.local_storage.system_components.Command;
import dnd_companion.game_helper.local_storage.system_components.Data;
import dnd_companion.game_helper.local_storage.system_components.DataKey;
import dnd_companion.game_helper.local_storage.system_components.ResultCommand;
import dnd_companion.game_helper.utils.ToolBox;
import dnd_companion.game_helper.utils.DataUtils;

public class RetrieveCommand extends Command
{
	private DataKey key;
	
	private Data result;
	public Data result
	
	private ObjectMapper mapper = new ObjectMapper();
	
	public RetrieveCommand(DataKey key) {
		this.key = key;
		this.result = null;
	}
	
	public RetrieveCommand execute() {
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
