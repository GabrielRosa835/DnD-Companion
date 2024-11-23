package dnd_companion.game_helper.main;

import dnd_companion.game_helper.local_storage.storage_build.StorageBuilder;
import dnd_companion.game_helper.local_storage.storage_build.storage_setup.OptionsSetup;
import dnd_companion.game_helper.utils.ToolBox;

public class Main 
{
	public static void main (String args[]) 
	{	
		try {			

			StorageBuilder.setup_directory_hierarquy();
			ToolBox.print("Worked? %b", new OptionsSetup().execute().status());
			
		} catch (Exception e) {
			ToolBox.print_err(e);
		}
	}
}
