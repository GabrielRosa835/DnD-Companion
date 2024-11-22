package dnd_companion.game_helper.local_storage.data_handling;

import dnd_companion.game_helper.local_storage.data.structure.OptionData;
import dnd_companion.game_helper.local_storage.data.structure.templates.AtomicOption;
import dnd_companion.game_helper.local_storage.system_components.Command;
import dnd_companion.game_helper.local_storage.system_components.DataKey;
import dnd_companion.game_helper.utils.ToolBox;

public class RetrieveOptionsCommand extends Command 
{
	private String option_group;
	
	private AtomicOption[] result;
	public AtomicOption[] result() {return this.result;}
	
	public RetrieveOptionsCommand(String option_group) {
		this.option_group = option_group;
	}
	
	public RetrieveOptionsCommand execute() {
		try {
			OptionData option_data = (OptionData) DataHandler.retrieve(new DataKey("options", option_group));
			result = option_data.options();
			status = true;
		} catch (Exception e) {
			ToolBox.print_err(e);
			status = false;
		}
		return this;
	}
}
