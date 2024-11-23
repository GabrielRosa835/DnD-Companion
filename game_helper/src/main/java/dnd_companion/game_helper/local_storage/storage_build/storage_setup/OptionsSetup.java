package dnd_companion.game_helper.local_storage.storage_build.storage_setup;

import java.util.Arrays;

import dnd_companion.game_helper.local_storage.data.structure.options.*;
import dnd_companion.game_helper.local_storage.data_build.DataBuilder;
import dnd_companion.game_helper.local_storage.data_handling.DataHandler;
import dnd_companion.game_helper.local_storage.system_components.Command;
import dnd_companion.game_helper.utils.ToolBox;

public class OptionsSetup extends Command
{
	public OptionsSetup execute() {
		try {
						DataHandler.save(DataBuilder.build_options(
					ArmorCategory.GROUP, 
					new ArmorCategory("None"),
					new ArmorCategory("Shield"),
					new ArmorCategory("Light"),
					new ArmorCategory("Medium"),
					new ArmorCategory("Heavy")));
			ToolBox.print("%s: %s", ArmorCategory.GROUP, Arrays.toString(DataHandler.retrieve_options(ArmorCategory.GROUP)));
			
			DataHandler.save(DataBuilder.build_options(
					Currency.GROUP, 
					new Currency("Normal", "NORM", 1),
					new Currency("Copper Piece", "CP", 1),
					new Currency("Silver Piece", "SP", 10),
					new Currency("Electurm Piece", "EP", 50),
					new Currency("Gold Piece", "GP", 100),
					new Currency("Platinum Piece", "PP", 1000)));
			ToolBox.print("%s: %s", Currency.GROUP, Arrays.toString(DataHandler.retrieve_options(Currency.GROUP)));
			
			DataHandler.save(DataBuilder.build_options(
					DamageType.GROUP,
					new DamageType("Acid"),
					new DamageType("Bludgeoning"),
					new DamageType("Cold"),
					new DamageType("Fire"),
					new DamageType("Force"),
					new DamageType("Lightning"),
					new DamageType("Necrotic"),
					new DamageType("Piercing"),
					new DamageType("Poison"),
					new DamageType("Psychic"),
					new DamageType("Radiant"),
					new DamageType("Slashing"),
					new DamageType("Thunder")));
			ToolBox.print("%s: %s", DamageType.GROUP, Arrays.toString(DataHandler.retrieve_options(DamageType.GROUP)));
			
			DataHandler.save(DataBuilder.build_options(
					DiceType.GROUP, 
					new DiceType("Tetrahedron", "D4", 4),
					new DiceType("Cube", "D6", 6),
					new DiceType("Octahedron", "D8", 8),
					new DiceType("10 Sided Pyramid", "D10", 10),
					new DiceType("Dodecahedron", "D12", 12),
					new DiceType("Icosahedron", "D20", 20)));
			ToolBox.print("%s: %s", DiceType.GROUP, Arrays.toString(DataHandler.retrieve_options(DiceType.GROUP)));

			DataHandler.save(DataBuilder.build_options(
					ItemTag.GROUP, 
					new ItemTag("Ammunition"),
					new ItemTag("Armor"),
					new ItemTag("Weapon"),
					new ItemTag("Food and Drink"),
					new ItemTag("Adventuring Gear"),
					new ItemTag("Tools"),
					new ItemTag("Instruments")));
			ToolBox.print("%s: %s", ItemTag.GROUP, Arrays.toString(DataHandler.retrieve_options(ItemTag.GROUP)));
			
			DataHandler.save(DataBuilder.build_options(
					LengthUnit.GROUP, 
					new LengthUnit("Normal", "NORM", 1),
					new LengthUnit("Meters", "M", 1.524),
					new LengthUnit("Centimeters", "CM", 152.4),
					new LengthUnit("Feet", "FT", 5),
					new LengthUnit("Inch", "M", 60),
					new LengthUnit("Squares", "S", 1)
					));
			ToolBox.print("%s: %s", LengthUnit.GROUP, Arrays.toString(DataHandler.retrieve_options(LengthUnit.GROUP)));
			
			DataHandler.save(DataBuilder.build_options(
					WeightUnit.GROUP, 
					new WeightUnit("Normal", "NORM", 1),
					new WeightUnit("Kilograms", "KG", 1000),
					new WeightUnit("Pounds", "LBS", 453.592),
					new WeightUnit("Grams", "G", 1),
					new WeightUnit("Ounces", "OZ", 28.3495)));
			ToolBox.print("%s: %s", WeightUnit.GROUP, Arrays.toString(DataHandler.retrieve_options(WeightUnit.GROUP)));
			
			this.status = true;
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.status = false;
		}		
		return this;
	}
}
