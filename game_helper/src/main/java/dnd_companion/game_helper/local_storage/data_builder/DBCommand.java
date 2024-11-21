package dnd_companion.game_helper.local_storage.data_builder;

import dnd_companion.game_helper.local_storage.Data;
import dnd_companion.game_helper.utils.Command;

public abstract class DBCommand extends Command 
{
	private Data result;
	public Data result() {return this.result;}
}
