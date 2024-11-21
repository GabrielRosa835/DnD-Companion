package dnd_companion.game_helper.local_storage.data.manipulation.atomic;

import dnd_companion.game_helper.local_storage.DataKey;
import dnd_companion.game_helper.local_storage.data.structure.OptionData;
import dnd_companion.game_helper.local_storage.data.structure.options.AtomicOption;
import dnd_companion.game_helper.local_storage.manager.LocalStorageManager;
import dnd_companion.game_helper.utils.Command;
import dnd_companion.game_helper.utils.ToolBox;

public class OptionRetrieverCommand extends Command 
{
	private String name;
	
	private AtomicOption[] result;
	public AtomicOption[] result() {return this.result;}
	
	public OptionRetrieverCommand(String name) {
		this.name = name;
	}
	
	public OptionRetrieverCommand execute() {
		try {
			OptionData option_data = (OptionData) LocalStorageManager.retrieve(new DataKey("options", name));
			result = option_data.options();
			status = true;
		} catch (Exception e) {
			ToolBox.print_err(e);
			status = false;
		}
		return this;
	}
}
