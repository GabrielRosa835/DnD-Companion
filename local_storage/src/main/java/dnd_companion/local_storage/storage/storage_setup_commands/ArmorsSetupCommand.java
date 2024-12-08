package dnd_companion.local_storage.storage.storage_setup_commands;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.common.command.Command;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.data.items.armors.ArmorCategoryData;
import dnd_companion.local_storage.structure.data.items.armors.ArmorData;

public class ArmorsSetupCommand extends Command<Boolean>
{
	private DataHandler data_handler = new DataHandler();	

	@Override
	public ArmorsSetupCommand execute() {
		try {
			data_handler.save_multiple(
					new ArmorCategoryData("None"),
					new ArmorCategoryData("Shield"),
					new ArmorCategoryData("Light"),
					new ArmorCategoryData("Medium"),
					new ArmorCategoryData("Heavy"));

			data_handler.save(new ArmorData(
					"Unarmored",
					0, "GP",
					0, "LBS",
					new String[]{"Armor"},
					"No description",
					"None",
					10, 0, false));
			data_handler.save(new ArmorData(
					"Leather Armor",
					10, "GP",
					10, "LBS",
					new String[]{"Armor"},
					"No description",
					"Light",
					11, 0, false));
			data_handler.save(new ArmorData(
					"Scale Mail",
					50, "GP",
					45, "LBS",
					new String[]{"Armor"},
					"No description",
					"Medium",
					14, 0, true));
			data_handler.save(new ArmorData(
					"Chain Mail",
					75, "GP",
					55, "LBS",
					new String[]{"Armor"},
					"No description",
					"Heavy",
					16, 13, true));

			this.status = true;
			this.result = true;
			this.message = "Armors successfully initialized";
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.status = false;
			this.result = false;
			this.message = "Failed to initialize armors";
		}
		return this;
	}
}
