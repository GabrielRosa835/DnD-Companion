package dnd_companion.storage.archives.setup_commands;

import dnd_companion.archives.local_storage.structure.items.armors.ArmorData;
import dnd_companion.common.Command;
import dnd_companion.common.metadata.UnitsMetadata;
import dnd_companion.entities.armor_related.ArmorCategoryData;
import dnd_companion.storage.archives.handling.DataHandler;

public class ArmorsSetupCommand extends Command<Boolean>
{
	private final DataHandler handler = new DataHandler();
	private final UnitsMetadata units = new UnitsMetadata();
	
	public ArmorsSetupCommand() {
		this.result = false;
		this.message = "Failed to setup armors";
	}
	
	@Override public void code() {
		handler.save_multiple(
			new ArmorCategoryData("None", 0, "None", 0, "None"),
			new ArmorCategoryData("Shield", 1, "Actions", 1, "Actions"),
			new ArmorCategoryData("Light", 1, "Minutes", 1, "Minutes"),
			new ArmorCategoryData("Medium", 5, "Minutes", 1, "Minutes"),
			new ArmorCategoryData("Heavy", 10, "Minutes", 5, "Minutes")
		);

		handler.save_multiple(
			new ArmorData(
				"Unarmored",
				0, units.get_name("gp"),
				0, units.get_name("lbs"),
				new String[]{"Armor"},
				"No description",
				"None",
				10, 0, false),
			new ArmorData(
				"Leather Armor",
				10, units.get_name("gp"),
				10, units.get_name("lbs"),
				new String[]{"Armor"},
				"No description",
				"Light",
				11, 0, false),
			new ArmorData(
				"Scale Mail",
				50, units.get_name("gp"),
				45, units.get_name("lbs"),
				new String[]{"Armor"},
				"No description",
				"Medium",
				14, 0, true),
			new ArmorData(
				"Chain Mail",
				75, units.get_name("gp"),
				55, units.get_name("lbs"),
				new String[]{"Armor"},
				"No description",
				"Heavy",
				16, 13, true)
		);
		this.result = true;
		this.message = "Armors' setup was successful";
	}
}
