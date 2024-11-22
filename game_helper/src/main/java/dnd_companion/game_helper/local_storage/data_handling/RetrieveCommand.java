package dnd_companion.game_helper.local_storage.data_handling;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import dnd_companion.game_helper.local_storage.data.structure.templates.AtomicOption;
import dnd_companion.game_helper.local_storage.data.structure.templates.Data;
import dnd_companion.game_helper.local_storage.system_components.CollectionClassMap;
import dnd_companion.game_helper.local_storage.system_components.Command;
import dnd_companion.game_helper.local_storage.system_components.DataKey;
import dnd_companion.game_helper.local_storage.system_components.OptionClassMap;
import dnd_companion.game_helper.utils.ToolBox;
import dnd_companion.game_helper.utils.DataUtils;

public class RetrieveCommand extends Command
{
	private DataKey key;
	
	private Data result;
	public Data result() {return this.result;}
	
	private ObjectMapper mapper = new ObjectMapper();
	
	public RetrieveCommand(DataKey key) {
		this.key = key;
		register_all_data_types();
	}
	
	private void register_all_data_types() {
        for (Class<?> clazz : OptionClassMap.mapping().values()) {
            if (AtomicOption.class.isAssignableFrom(clazz)) {
                mapper.registerSubtypes(clazz);
            }
        }
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
