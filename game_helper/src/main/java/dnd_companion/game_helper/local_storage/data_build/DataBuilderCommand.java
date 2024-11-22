package dnd_companion.game_helper.local_storage.data_build;

import dnd_companion.game_helper.local_storage.data.structure.templates.Data;
import dnd_companion.game_helper.local_storage.system_components.Command;

public abstract class DataBuilderCommand extends Command
{
	protected Data result;
	public Data result() {return this.result;}
	
	public DataBuilderCommand() {
		super();
		this.result = null;
	}
}
