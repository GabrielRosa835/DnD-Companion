package src.storage_build.storage_setup;

import src.data_handling.DataHandler;
import src.data_structure.json.items.ItemTagData;
import src.data_structure.json.items.armors.ArmorCategoryData;
import src.data_structure.json.items.weapons.WeaponCategoryData;
import src.data_structure.json.items.weapons.WeaponMasteryData;
import src.data_structure.json.items.weapons.WeaponPropertyData;
import src.data_structure.json.items.weapons.WeaponTypeData;
import src.data_structure.json.system.DamageTypeData;
import src.data_structure.json.system.DiceTypeData;
import src.data_structure.json.system.units.CurrencyUnitData;
import src.data_structure.json.system.units.LengthUnitData;
import src.data_structure.json.system.units.WeightUnitData;
import src.system_components.Command;
import src.system_components.ToolBox;

public class OptionsSetupCommand extends Command {
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
