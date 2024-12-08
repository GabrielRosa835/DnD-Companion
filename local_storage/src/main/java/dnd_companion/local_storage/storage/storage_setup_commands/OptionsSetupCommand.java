package dnd_companion.local_storage.storage.storage_setup_commands;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.common.command.Command;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.data.items.tags.ItemTagData;
import dnd_companion.local_storage.structure.data.system.DamageTypeData;
import dnd_companion.local_storage.structure.data.system.DiceData;
import dnd_companion.local_storage.structure.data.system.units.CurrencyData;
import dnd_companion.local_storage.structure.data.system.units.LengthUnitData;
import dnd_companion.local_storage.structure.data.system.units.WeightUnitData;

public class OptionsSetupCommand extends Command<Boolean>
{
	private DataHandler data_handler = new DataHandler();
	
	@Override
	public OptionsSetupCommand execute() {
		try {
			data_handler.save_multiple(
				new CurrencyData("Copper Piece", "CP", 1),
				new CurrencyData("Silver Piece", "SP", 10),
				new CurrencyData("Electurm Piece", "EP", 50),
				new CurrencyData("Gold Piece", "GP", 100),
				new CurrencyData("Platinum Piece", "PP", 1000)
			);
			data_handler.save_multiple(
				new LengthUnitData("Meters", "M", 1),
				new LengthUnitData("Centimeters", "CM", 100),
				new LengthUnitData("Feet", "FT", 3.28084),
				new LengthUnitData("Inch", "M", 39.3701),
				new LengthUnitData("Squares", "S", 1.5)
			);
			data_handler.save_multiple(
				new WeightUnitData("Kilograms", "KG", 1),
				new WeightUnitData("Pounds", "LBS", 2.20462),
				new WeightUnitData("Grams", "G", 1000),
				new WeightUnitData("Ounces", "OZ", 35.274)
			);
			data_handler.save_multiple(
				new DamageTypeData("Acid"),
				new DamageTypeData("Bludgeoning"),
				new DamageTypeData("Cold"),
				new DamageTypeData("Fire"),
				new DamageTypeData("Force"),
				new DamageTypeData("Lightning"),
				new DamageTypeData("Necrotic"),
				new DamageTypeData("Piercing"),
				new DamageTypeData("Poison"),
				new DamageTypeData("Psychic"),
				new DamageTypeData("Radiant"),
				new DamageTypeData("Slashing"),
				new DamageTypeData("Thunder")
			);
			data_handler.save_multiple(
				new DiceData(4),
				new DiceData(6),
				new DiceData(8),
				new DiceData(10),
				new DiceData(12),
				new DiceData(20)
			);
			data_handler.save_multiple(
				new ItemTagData("Armor"),
				new ItemTagData("Weapon"),
				new ItemTagData("Magical"),
				new ItemTagData("Food and Drink"),
				new ItemTagData("Ammunition"),
				new ItemTagData("Adventuring Gear"),
				new ItemTagData("Tool"),
				new ItemTagData("Instrument")
			);
			this.status = true;
			this.result = true;
			this.message = "All options saved successfully";
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.clear();
		}
		return this;
	}
}
