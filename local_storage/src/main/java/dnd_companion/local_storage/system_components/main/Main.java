package dnd_companion.local_storage.system_components.main;

import dnd_companion.local_storage.storage_build.StorageBuilder;
import dnd_companion.local_storage.system_components.utils.ToolBox;

public class Main 
{
	public static void main (String args[]) 
	{	
		try {			
			
			ToolBox.print("Setup Armor: %b", StorageBuilder.setup_armors());
			
		} catch (Exception e) {
			ToolBox.print_err(e);
		}
	}
}
