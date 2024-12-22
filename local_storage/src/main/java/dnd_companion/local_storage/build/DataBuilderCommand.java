package dnd_companion.local_storage.build;

import dnd_companion.local_storage.models.common.Command;
import dnd_companion.local_storage.models.data.Data;

public abstract class DataBuilderCommand<T extends Data> extends Command
{
	protected T result;
	public T result() {return this.result;}

	public DataBuilderCommand() {
		super();
		this.result = null;
	}
}
