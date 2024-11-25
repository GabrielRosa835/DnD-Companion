package dnd_companion.local_storage.storage_build.storage_setup;

import dnd_companion.local_storage.data.manipulation.ItemTags;
import dnd_companion.local_storage.data.manipulation.price.Price;
import dnd_companion.local_storage.data.manipulation.weight.Weight;
import dnd_companion.local_storage.data.structure.ArmorData;
import dnd_companion.local_storage.data.structure.options.ArmorCategory;
import dnd_companion.local_storage.data.structure.templates.Data;
import dnd_companion.local_storage.data_build.DataBuilder;
import dnd_companion.local_storage.data_handling.DataHandler;
import dnd_companion.local_storage.system_components.Command;
import dnd_companion.local_storage.system_components.DataKey;
import dnd_companion.local_storage.system_components.utils.ToolBox;

public class ArmorsSetupCommand extends Command 
{
	private static void check(Data data) {
		DataKey key = new DataKey(data);
		Data checked_data = DataHandler.retrieve(key);
		ToolBox.print("%s: %s", data.name(), checked_data.toString());
	}
	
	public ArmorsSetupCommand execute() {
		ToolBox.print("Reached here: %s", ArmorsSetupCommand.class.getName());
		ArmorData no_armor = DataBuilder.build_armor(
				"None",
				new Price(0, "NORM"),
				new Weight(0, "NORM"),
				new ItemTags("Armor"),
				"No description",
				new ArmorCategory("None"),
				10, 0, false);
		DataHandler.save(no_armor);
//		check(no_armor);
		
		
//		try {
//			
//			ArmorData leather_armor = DataBuilder.build_armor(
//					"Leather Armor",
//					new Price(10, "GP"),
//					new Weight(10, "LBS"),
//					new ItemTags("Armor"),
//					"No description",
//					new ArmorCategory("Light"),
//					11, 0, false);
//			DataHandler.save(leather_armor);
//			check(leather_armor);
//			
//			ArmorData scale_mail = DataBuilder.build_armor(
//					"Leather Armor",
//					new Price(50, "GP"),
//					new Weight(45, "LBS"),
//					new ItemTags("Armor"),
//					"No description",
//					new ArmorCategory("Medium"),
//					14, 0, true);
//			DataHandler.save(scale_mail);
//			check(scale_mail);
//			
//			ArmorData chain_mail = DataBuilder.build_armor(
//					"Leather Armor",
//					new Price(75, "GP"),
//					new Weight(55, "LBS"),
//					new ItemTags("Armor"),
//					"No description",
//					new ArmorCategory("Heavy"),
//					16, 13, true);
//			DataHandler.save(chain_mail);
//			check(chain_mail);
//									
//			this.status = true;
//		} catch (Exception e) {
//			ToolBox.print_err(e);
//			this.status = false;
//		}		
		return this;
	}
}
