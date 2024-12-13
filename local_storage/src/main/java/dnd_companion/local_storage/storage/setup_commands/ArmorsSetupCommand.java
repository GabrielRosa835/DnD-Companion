package dnd_companion.local_storage.storage.setup_commands;

import dnd_companion.local_storage.common.command.Command;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.data.items.armors.ArmorCategoryData;
import dnd_companion.local_storage.structure.data.items.armors.ArmorData;

public class ArmorsSetupCommand extends Command<ArmorsSetupCommand, Boolean>
{
	public ArmorsSetupCommand() {
		this.message = "Failed to setup armors";
	}
	
	@Override public void code() {
		DataHandler data_handler = new DataHandler();	
		
		data_handler.save_multiple(
			new ArmorCategoryData("None", 0, "None", 0, "None"),
			new ArmorCategoryData("Shield", 1, "Action", 1, "Action"),
			new ArmorCategoryData("Light", 1, "Minutes", 1, "Minutes"),
			new ArmorCategoryData("Medium", 5, "Minutes", 1, "Minutes"),
			new ArmorCategoryData("Heavy", 10, "Minutes", 5, "Minutes")
		);

		data_handler.save_multiple(
			new ArmorData(
				"Unarmored",
				0, "GP",
				0, "LBS",
				new String[]{"Armor"},
				"No description",
				"None",
				10, 0, false),
			new ArmorData(
				"Leather Armor",
				10, "GP",
				10, "LBS",
				new String[]{"Armor"},
				"No description",
				"Light",
				11, 0, false),
			new ArmorData(
				"Scale Mail",
				50, "GP",
				45, "LBS",
				new String[]{"Armor"},
				"No description",
				"Medium",
				14, 0, true),
			new ArmorData(
				"Chain Mail",
				75, "GP",
				55, "LBS",
				new String[]{"Armor"},
				"No description",
				"Heavy",
				16, 13, true)
		);
		
		this.result = true;
		this.message = "Armors' setup was successful";
	}
}
