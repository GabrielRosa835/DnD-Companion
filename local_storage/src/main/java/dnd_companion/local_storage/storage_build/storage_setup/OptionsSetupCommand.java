package dnd_companion.local_storage.storage_build.storage_setup;

import dnd_companion.local_storage.data_handling.DataHandler;
import dnd_companion.local_storage.data_structure.json.items.ItemTagData;
import dnd_companion.local_storage.data_structure.json.items.armors.ArmorCategoryData;
import dnd_companion.local_storage.data_structure.json.items.weapons.WeaponCategoryData;
import dnd_companion.local_storage.data_structure.json.items.weapons.WeaponMasteryData;
import dnd_companion.local_storage.data_structure.json.items.weapons.WeaponPropertyData;
import dnd_companion.local_storage.data_structure.json.items.weapons.WeaponTypeData;
import dnd_companion.local_storage.data_structure.json.system.DamageTypeData;
import dnd_companion.local_storage.data_structure.json.system.DiceTypeData;
import dnd_companion.local_storage.data_structure.json.system.units.CurrencyUnitData;
import dnd_companion.local_storage.data_structure.json.system.units.LengthUnitData;
import dnd_companion.local_storage.data_structure.json.system.units.WeightUnitData;
import dnd_companion.local_storage.system_components.Command;
import dnd_companion.local_storage.system_components.ToolBox;

public class OptionsSetupCommand extends Command
{
	@Override
	public OptionsSetupCommand execute() {
		try {
			DataHandler.save(new DamageTypeData());
			DataHandler.save(new ItemTagData());
			DataHandler.save(new DiceTypeData());
			DataHandler.save(new CurrencyUnitData());
			DataHandler.save(new LengthUnitData());
			DataHandler.save(new WeightUnitData());
			DataHandler.save(new ArmorCategoryData());
			DataHandler.save(new WeaponCategoryData());
			DataHandler.save(new WeaponMasteryData());
			DataHandler.save(new WeaponPropertyData());
			DataHandler.save(new WeaponTypeData());
			this.status = true;
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.status = false;
		}
		return this;
	}
}
