package dnd_companion.local_storage.data_handling;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import dnd_companion.local_storage.data.structure.templates.Data;
import dnd_companion.local_storage.system_components.Command;
import dnd_companion.local_storage.system_components.DataKey;
import dnd_companion.local_storage.system_components.utils.DataUtils;
import dnd_companion.local_storage.system_components.utils.ToolBox;

public class RetrieveDataCommand extends Command
{
	private DataKey key;
	
	private Data result;
	public Data result() {return this.result;}
	
	private ObjectReader reader = new ObjectMapper().readerFor(Data.class);
	
	public RetrieveDataCommand(DataKey key) {
		this.key = key;
	}
	
	public RetrieveDataCommand execute() {
		try {
			File file = new File(DataUtils.create_file_path(key));
			Data data = reader.readValue(file);
			ToolBox.print("Data retrieved successfully: %s", data.name());
			this.result = data;
			this.status = true;
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.result = null;
			this.status = false;
		}
		return this;
	}
}
