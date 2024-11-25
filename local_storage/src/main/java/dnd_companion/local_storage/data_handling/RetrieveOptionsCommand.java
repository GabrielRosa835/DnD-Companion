package dnd_companion.local_storage.data_handling;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import dnd_companion.local_storage.data.structure.OptionData;
import dnd_companion.local_storage.data.structure.templates.AtomicOption;
import dnd_companion.local_storage.system_components.Command;
import dnd_companion.local_storage.system_components.DataKey;
import dnd_companion.local_storage.system_components.utils.DataUtils;
import dnd_companion.local_storage.system_components.utils.ToolBox;

public class RetrieveOptionsCommand extends Command 
{
	private String option_group;
	
	private AtomicOption[] result;
	public AtomicOption[] result() {return this.result;}
	
	private ObjectReader reader = new ObjectMapper().readerFor(OptionData.class);
	
	public RetrieveOptionsCommand(String option_group) {
		this.option_group = option_group;
	}
	
	public RetrieveOptionsCommand execute() {
		try {
			File file = new File(DataUtils.create_file_path(new DataKey(OptionData.COLLECTION, option_group)));
			OptionData data = reader.readValue(file);
			ToolBox.print("Options retrieved successfully: %s", option_group);
			result = data.options();
			status = true;
		} catch (Exception e) {
			ToolBox.print_err(e);
			status = false;
		}
		return this;
	}
}
