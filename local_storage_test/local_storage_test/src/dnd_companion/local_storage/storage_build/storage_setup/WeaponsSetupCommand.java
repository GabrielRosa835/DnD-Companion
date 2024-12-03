package src.storage_build.storage_setup;

import src.data_handling.DataHandler;
import src.data_structure.json.items.weapons.WeaponData;
import src.data_structure.json.templates.Data;
import src.system_components.Command;
import src.system_components.DataKey;
import src.system_components.ToolBox;

public class WeaponsSetupCommand extends Command {
    private static void check(WeaponData data) {
        DataKey key = new DataKey(data);
        Data checked_data = DataHandler.retrieve(key);
        ToolBox.print("%s: %s", data.name(), checked_data.toString());
    }

    @Override
    public WeaponsSetupCommand execute() {
        try {
//			WeaponData no_armor = DataBuilder.build_armor(
//					"Unarmored",
//					new Price(0, "GP"),
//					new Weight(0, "LBS"),
//					new String[]{"Armor"},
//					"No description",
//					"NONE",
//					10, 0, false);
//			DataHandler.save(no_armor);
//			check(no_armor);

            this.status = true;
        } catch (Exception e) {
            ToolBox.print_err(e);
            this.status = false;
        }
        return this;
    }
}
