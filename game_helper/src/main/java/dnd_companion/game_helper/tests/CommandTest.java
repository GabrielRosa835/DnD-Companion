package dnd_companion.game_helper.tests;

import dnd_companion.game_helper.utils.Command;
import dnd_companion.game_helper.utils.ToolBox;

public abstract class CommandTest extends Command
{
	protected Object result;
	
	public void print() {
		ToolBox.print("Result: %s", result.toString());
	};
}
