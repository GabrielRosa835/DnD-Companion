package dnd_companion.local_storage.system_components.main;

import dnd_companion.local_storage.storage_build.storage_setup.ArmorsSetupCommand;
import dnd_companion.local_storage.system_components.utils.ToolBox;

public class Main 
{
	public static void main (String args[]) 
	{	
		ToolBox.print("Armor Setup: %b", new ArmorsSetupCommand().execute().status());
	}
}
