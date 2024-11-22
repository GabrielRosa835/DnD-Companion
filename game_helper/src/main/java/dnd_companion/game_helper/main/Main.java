package dnd_companion.game_helper.main;

import java.util.Arrays;

import dnd_companion.game_helper.local_storage.data_handling.DataHandler;
import dnd_companion.game_helper.utils.ToolBox;

public class Main 
{
	public static void main (String args[]) 
	{	
		try {			
			
//			ToolBox.print("Worked? %b", DataHandler.save(DataBuilder.build_options(
//					"armor-categories", 
//					new ArmorCategory("NONE"),
//					new ArmorCategory("SHIELD"),
//					new ArmorCategory("LIGHT"),
//					new ArmorCategory("MEDIUM"),
//					new ArmorCategory("HEAVY"))));
			
			ToolBox.print("%s", Arrays.toString(DataHandler.retrieve_options("armor-categories")));
						
			
		} catch (Exception e) {
			ToolBox.print_err(e);
		}
	}
}
