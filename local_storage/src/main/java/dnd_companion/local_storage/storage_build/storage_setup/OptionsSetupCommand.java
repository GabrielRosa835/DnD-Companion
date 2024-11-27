package dnd_companion.local_storage.storage_build.storage_setup;

import dnd_companion.local_storage.data.structure.atomic.Currency;
import dnd_companion.local_storage.data.structure.atomic.DiceType;
import dnd_companion.local_storage.data.structure.atomic.LengthUnit;
import dnd_companion.local_storage.data.structure.atomic.WeightUnit;
import dnd_companion.local_storage.data.structure.items.ItemTagData;
import dnd_companion.local_storage.data.structure.items.armors.ArmorCategoryData;
import dnd_companion.local_storage.data.structure.system.DamageTypeData;
import dnd_companion.local_storage.data.structure.system.DiceTypeData;
import dnd_companion.local_storage.data.structure.system.units.CurrencyData;
import dnd_companion.local_storage.data.structure.system.units.LengthUnitData;
import dnd_companion.local_storage.data.structure.system.units.WeightUnitData;
import dnd_companion.local_storage.data_handling.DataHandler;
import dnd_companion.local_storage.system_components.Command;
import dnd_companion.local_storage.system_components.utils.ToolBox;

public class OptionsSetupCommand extends Command
{
	public OptionsSetupCommand execute() {
		try {
			ArmorCategoryData armor_category_data = new ArmorCategoryData(
					"None", 
					"Shield", 
					"Light", 
					"Medium", 
					"Heavy"); 
			DataHandler.save(armor_category_data);
			
			DamageTypeData damage_type_data = new DamageTypeData(
					"Acid",
					"Bludgeoning",
					"Cold",
					"Fire",
					"Force",
					"Lightning",
					"Necrotic",
					"Piercing",
					"Poison",
					"Psychic",
					"Radiant",
					"Slashing",
					"Thunder");
			DataHandler.save(damage_type_data);
			
			ItemTagData item_tag_data = new ItemTagData(
					"Ammunition",
					"Armor",
					"Weapon",
					"Food and Drink",
					"Adventuring Gear",
					"Tool",
					"Instrument");
			DataHandler.save(item_tag_data);
			
			DiceTypeData dice_type_data = new DiceTypeData(
					new DiceType("D4", 4),
					new DiceType("D6", 6),
					new DiceType("D8", 8),
					new DiceType("D10", 10),
					new DiceType("D12", 12),
					new DiceType("D20", 20));
			DataHandler.save(dice_type_data);
			
			CurrencyData currency_data = new CurrencyData(
					new Currency("Normal", "NORM", 1),
					new Currency("Copper Piece", "CP", 1),
					new Currency("Silver Piece", "SP", 10),
					new Currency("Electurm Piece", "EP", 50),
					new Currency("Gold Piece", "GP", 100),
					new Currency("Platinum Piece", "PP", 1000)); 
			DataHandler.save(currency_data);
			
			LengthUnitData length_unit_data = new LengthUnitData(
					new LengthUnit("Normal", "NORM", 1),
					new LengthUnit("Meters", "M", 1.524),
					new LengthUnit("Centimeters", "CM", 152.4),
					new LengthUnit("Feet", "FT", 5),
					new LengthUnit("Inch", "M", 60),
					new LengthUnit("Squares", "S", 1));
			DataHandler.save(length_unit_data);
			
			WeightUnitData weight_unit_data = new WeightUnitData(
					new WeightUnit("Normal", "NORM", 1),
					new WeightUnit("Kilograms", "KG", 1000),
					new WeightUnit("Pounds", "LBS", 453.592),
					new WeightUnit("Grams", "G", 1),
					new WeightUnit("Ounces", "OZ", 28.3495));
			DataHandler.save(weight_unit_data);
			
			this.status = true;
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.status = false;
		}		
		return this;
	}
}
