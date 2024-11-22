package dnd_companion.game_helper.local_storage.data_handler;

import dnd_companion.game_helper.local_storage.data.structure.OptionData;
import dnd_companion.game_helper.local_storage.data.structure.options.AtomicOption;
import dnd_companion.game_helper.local_storage.system_components.Command;
import dnd_companion.game_helper.local_storage.system_components.DataKey;
import dnd_companion.game_helper.utils.ToolBox;

public class RetrieveOptionsCommand extends Command 
{
	private String name;
	
	private AtomicOption[] result;
	public AtomicOption[] result() {return this.result;}
	
	public RetrieveOptionsCommand(String name) {
		this.name = name;
	}
	
	public RetrieveOptionsCommand execute() {
		try {
			OptionData option_data = (OptionData) DataHandler.retrieve(new DataKey("options", name));
			result = option_data.options();
			status = true;
		} catch (Exception e) {
			ToolBox.print_err(e);
			status = false;
		}
		return this;
	}
}
