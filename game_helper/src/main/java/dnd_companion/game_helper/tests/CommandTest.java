package dnd_companion.game_helper.tests;

import dnd_companion.game_helper.local_storage.commands.Command;
import dnd_companion.game_helper.utils.ToolBox;

public abstract class CommandTest extends Command
{
	protected Object result;
	
	public void print() {
		ToolBox.print("Result: %s", result.toString());
	};
}
