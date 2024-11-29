package dnd_companion.local_storage.data_build;

import dnd_companion.local_storage.data_structure.json.templates.Data;
import dnd_companion.local_storage.system_components.Command;

public abstract class DataBuilderCommand<T extends Data> extends Command
{
	protected T result;
	public T result() {return this.result;}

	public DataBuilderCommand() {
		super();
		this.result = null;
	}
}
