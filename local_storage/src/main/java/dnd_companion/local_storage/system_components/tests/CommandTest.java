package dnd_companion.local_storage.system_components.tests;

import dnd_companion.local_storage.system_components.Command;
import dnd_companion.local_storage.system_components.utils.ToolBox;

public abstract class CommandTest extends Command
{
	protected Object result;
	
	public void print() {
		ToolBox.print("Result: %s", result.toString());
	};
}
