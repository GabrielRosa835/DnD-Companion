package dnd_companion.game_helper.local_storage.data_build;

import dnd_companion.game_helper.local_storage.system_components.Command;
import dnd_companion.game_helper.local_storage.system_components.Data;

public abstract class DataBuilderCommand extends Command
{
	protected Data result;
	public Data result() {return this.result;}
}
