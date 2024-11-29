package dnd_companion.local_storage.storage_build.storage_setup;

import dnd_companion.local_storage.data_build.DataBuilder;
import dnd_companion.local_storage.data_handling.DataHandler;
import dnd_companion.local_storage.data_structure.java.system.units.Price;
import dnd_companion.local_storage.data_structure.java.system.units.Weight;
import dnd_companion.local_storage.data_structure.json.items.armors.ArmorData;
import dnd_companion.local_storage.data_structure.json.templates.Data;
import dnd_companion.local_storage.system_components.Command;
import dnd_companion.local_storage.system_components.DataKey;
import dnd_companion.local_storage.system_components.ToolBox;

public class ArmorsSetupCommand extends Command
{
	private static void check(ArmorData data) {
		DataKey key = new DataKey(data);
		Data checked_data = DataHandler.retrieve(key);
		ToolBox.print("%s: %s", data.name(), checked_data.toString());
	}

	@Override
	public ArmorsSetupCommand execute() {
		try {
			ArmorData no_armor = DataBuilder.build_armor(
					"Unarmored",
					new Price(0, "GP"),
					new Weight(0, "LBS"),
					new String[]{"Armor"},
					"No description",
					"None",
					10, 0, false);
			DataHandler.save(no_armor);
			check(no_armor);

			ArmorData leather_armor = DataBuilder.build_armor(
					"Leather Armor",
					new Price(10, "GP"),
					new Weight(10, "LBS"),
					new String[]{"Armor"},
					"No description",
					"Light",
					11, 0, false);
			DataHandler.save(leather_armor);
			check(leather_armor);

			ArmorData scale_mail = DataBuilder.build_armor(
					"Scale Mail",
					new Price(50, "GP"),
					new Weight(45, "LBS"),
					new String[]{"Armor"},
					"No description",
					"Medium",
					14, 0, true);
			DataHandler.save(scale_mail);
			check(scale_mail);

			ArmorData chain_mail = DataBuilder.build_armor(
					"Chain Mail",
					new Price(75, "GP"),
					new Weight(55, "LBS"),
					new String[]{"Armor"},
					"No description",
					"Heavy",
					16, 13, true);
			DataHandler.save(chain_mail);
			check(chain_mail);

			this.status = true;
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.status = false;
		}
		return this;
	}
}
