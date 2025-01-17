package dnd_companion.archives.local_storage.storage.setup_commands;

import dnd_companion.archives.local_storage.handling.DataHandler;
import dnd_companion.archives.local_storage.structure.system.units.CurrencyUnitData;
import dnd_companion.archives.local_storage.structure.system.units.LengthUnitData;
import dnd_companion.archives.local_storage.structure.system.units.TimeUnitData;
import dnd_companion.archives.local_storage.structure.system.units.WeightUnitData;
import dnd_companion.common.Command;

public class UnitsSetupCommand extends Command<Boolean>
{
	public UnitsSetupCommand() {
		this.message = "Failed to setup units";
	}
	
	@Override public void code() {
		DataHandler data_handler = new DataHandler();
		data_handler.save_multiple(
			new CurrencyUnitData("None", "None", "n", 0),	
			new CurrencyUnitData("Copper Piece", "Copper Pieces", "cp", 1),
			new CurrencyUnitData("Silver Piece", "Silver Pieces", "sp", 10),
			new CurrencyUnitData("Electrum Piece", "Electrum Pieces", "ep", 50),
			new CurrencyUnitData("Gold Piece", "Gold Pieces", "gp", 100),
			new CurrencyUnitData("Platinum Piece", "Platinum Pieces", "pp", 1000)
		);
		data_handler.save_multiple(
			new LengthUnitData("None", "None", "n", 0),	
			new LengthUnitData("Meter", "Meters", "m", 1),
			new LengthUnitData("Centimeter", "Centimeters", "cm", 100),
			new LengthUnitData("Foot", "Feet", "ft", 3.28084),
			new LengthUnitData("Inch", "Inches", "in", 39.3701),
			new LengthUnitData("Square", "Squares", "sq", 1.5)
		);
		data_handler.save_multiple(
			new WeightUnitData("None", "None", "n", 0),	
			new WeightUnitData("Kilogram", "Kilograms", "kg", 1),
			new WeightUnitData("Pound", "Pounds", "lbs", 2.20462),
			new WeightUnitData("Gram", "Grams", "g", 1000),
			new WeightUnitData("Ounce", "Ounces", "oz", 35.274)
		);
		data_handler.save_multiple(
			new TimeUnitData("None", "None", "n", 0),	
			new TimeUnitData("Second", "Seconds", "s", 3600),
			new TimeUnitData("Minute", "Minutes", "m", 60),
			new TimeUnitData("Hour", "Hours", "h", 1),
			new TimeUnitData("Day", "Days", "d", 0.0416667),
			new TimeUnitData("Week", "Weeks", "w", 0.00595238),
			new TimeUnitData("Action", "Actions", "a", 0.00166667)
		);
		this.result = true;
		this.message = "Units' setup was successful";
	}
}
