package dnd_companion.local_storage.storage.storage_setup;

import dnd_companion.local_storage.common.Command;
import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.data.items.ItemTagData;
import dnd_companion.local_storage.structure.data.items.armors.ArmorCategoryData;
import dnd_companion.local_storage.structure.data.items.weapons.WeaponCategoryData;
import dnd_companion.local_storage.structure.data.items.weapons.WeaponMasteryData;
import dnd_companion.local_storage.structure.data.items.weapons.WeaponPropertyData;
import dnd_companion.local_storage.structure.data.items.weapons.WeaponTypeData;
import dnd_companion.local_storage.structure.data.system.DamageTypeData;
import dnd_companion.local_storage.structure.data.system.DiceTypeData;
import dnd_companion.local_storage.structure.data.system.units.CurrencyUnitData;
import dnd_companion.local_storage.structure.data.system.units.LengthUnitData;
import dnd_companion.local_storage.structure.data.system.units.WeightUnitData;

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
