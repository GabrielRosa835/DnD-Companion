package dnd_companion.game_helper.local_storage.data_build;

import dnd_companion.game_helper.local_storage.data.structure.OptionData;
import dnd_companion.game_helper.local_storage.data.structure.templates.AtomicOption;
import dnd_companion.game_helper.utils.ToolBox;

public class BuildOptionsCommand extends DataBuilderCommand
{
	private String name;
	private AtomicOption[] options;
	
	public BuildOptionsCommand(String name, AtomicOption[] options) {
		super();
		this.name = name;
		this.options = options;
	}

	public BuildOptionsCommand execute() {
		try {
			OptionData data = new OptionData(
				this.name,
				this.options
			);			
			this.result = data;
			this.status = true;
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.status = false;
		}
		return this;
	}
}
