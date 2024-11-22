package dnd_companion.game_helper.tests;

import dnd_companion.game_helper.local_storage.system_components.Command;
import dnd_companion.game_helper.utils.ToolBox;

public abstract class CommandTest extends Command
{
	protected Object result;
	
	public void print() {
		ToolBox.print("Result: %s", result.toString());
	};
}
