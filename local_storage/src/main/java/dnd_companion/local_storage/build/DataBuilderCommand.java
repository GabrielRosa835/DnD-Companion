package dnd_companion.local_storage.build;

import dnd_companion.local_storage.common.command.Command;
import dnd_companion.local_storage.structure.data.Data;

public abstract class DataBuilderCommand<T extends Data> extends Command
{
	protected T result;
	public T result() {return this.result;}

	public DataBuilderCommand() {
		super();
		this.result = null;
	}
}
