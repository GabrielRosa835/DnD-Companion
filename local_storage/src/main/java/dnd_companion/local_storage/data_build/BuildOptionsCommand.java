package dnd_companion.local_storage.data_build;

import dnd_companion.local_storage.data.structure.OptionData;
import dnd_companion.local_storage.data.structure.templates.AtomicOption;
import dnd_companion.local_storage.system_components.utils.ToolBox;

public class BuildOptionsCommand extends DataBuilderCommand
{
	private AtomicOption[] options;
	
	public BuildOptionsCommand(AtomicOption[] options) {
		super();
		this.options = options;
	}

	public BuildOptionsCommand execute() {
		try {
			OptionData data = new OptionData(
				this.options[0].group(),
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
