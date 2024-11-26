package dnd_companion.local_storage.data_build;

import java.util.Collection;

import dnd_companion.local_storage.data.structure.templates.OptionData;
import dnd_companion.local_storage.system_components.utils.ToolBox;

public class BuildOptionsCommand<T> extends DataBuilderCommand
{
	private Collection<T> options;
	private Class<OptionData<T>> data_class;
	
	public BuildOptionsCommand(Collection<T> options, Class<OptionData<T>> data_class) {
		super();
		this.options = options;
		this.data_class = data_class;
	}

	public BuildOptionsCommand<T> execute() {
		try {
			OptionData<T> data = data_class.getConstructor().newInstance(options);
			this.result = data;
			this.status = true;
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.status = false;
		}
		return this;
	}
}
