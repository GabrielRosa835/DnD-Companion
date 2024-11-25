package dnd_companion.local_storage.storage_build.storage_setup;

import java.util.Arrays;

import dnd_companion.local_storage.data.structure.units.Currency;
import dnd_companion.local_storage.data.structure.units.LengthUnit;
import dnd_companion.local_storage.data.structure.units.WeightUnit;
import dnd_companion.local_storage.data_build.DataBuilder;
import dnd_companion.local_storage.data_handling.DataHandler;
import dnd_companion.local_storage.system_components.Command;
import dnd_companion.local_storage.system_components.utils.ToolBox;

public class UnitsSetupCommand extends Command
{
	public UnitsSetupCommand execute() {
		try {			
			DataHandler.save(DataBuilder.build_units(
					new Currency("Normal", "NORM", 1),
					new Currency("Copper Piece", "CP", 1),
					new Currency("Silver Piece", "SP", 10),
					new Currency("Electurm Piece", "EP", 50),
					new Currency("Gold Piece", "GP", 100),
					new Currency("Platinum Piece", "PP", 1000)));
			ToolBox.print("%s: %s", Currency.GROUP, Arrays.toString(DataHandler.retrieve_units(Currency.GROUP)));
			
			DataHandler.save(DataBuilder.build_units(
					new LengthUnit("Normal", "NORM", 1),
					new LengthUnit("Meters", "M", 1.524),
					new LengthUnit("Centimeters", "CM", 152.4),
					new LengthUnit("Feet", "FT", 5),
					new LengthUnit("Inch", "M", 60),
					new LengthUnit("Squares", "S", 1)
					));
			ToolBox.print("%s: %s", LengthUnit.GROUP, Arrays.toString(DataHandler.retrieve_units(LengthUnit.GROUP)));
			
			DataHandler.save(DataBuilder.build_units(
					new WeightUnit("Normal", "NORM", 1),
					new WeightUnit("Kilograms", "KG", 1000),
					new WeightUnit("Pounds", "LBS", 453.592),
					new WeightUnit("Grams", "G", 1),
					new WeightUnit("Ounces", "OZ", 28.3495)));
			ToolBox.print("%s: %s", WeightUnit.GROUP, Arrays.toString(DataHandler.retrieve_units(WeightUnit.GROUP)));
			
			this.status = true;
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.status = false;
		}		
		return this;
	}
}
