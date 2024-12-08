package dnd_companion.local_storage.storage.setup_commands;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.common.command.Command;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.data.system.units.CurrencyUnitData;
import dnd_companion.local_storage.structure.data.system.units.LengthUnitData;
import dnd_companion.local_storage.structure.data.system.units.TimeUnitData;
import dnd_companion.local_storage.structure.data.system.units.WeightUnitData;

public class UnitsSetupCommand extends Command<Boolean>
{
	private DataHandler data_handler = new DataHandler();
	
	@Override
	public UnitsSetupCommand execute() {
		try {
			data_handler.save_multiple(
				new CurrencyUnitData("Copper Piece", "CP", 1),
				new CurrencyUnitData("Silver Piece", "SP", 10),
				new CurrencyUnitData("Electurm Piece", "EP", 50),
				new CurrencyUnitData("Gold Piece", "GP", 100),
				new CurrencyUnitData("Platinum Piece", "PP", 1000)
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
				new TimeUnitData("Seconds", "s", 1),
				new TimeUnitData("Minutes", "m", 1),
				new TimeUnitData("Hours", "h", 1),
				new TimeUnitData("Days", "d", 1),
				new TimeUnitData("Weeks", "w", 1)
			);
			this.status = true;
			this.result = true;
			this.message = "Units' setup was successful";
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.status = false;
			this.result = false;
			this.message = "Failed to setup units";
		}
		return this;
	}
}
