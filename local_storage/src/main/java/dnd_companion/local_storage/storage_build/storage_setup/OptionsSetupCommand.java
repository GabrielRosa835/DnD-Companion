package dnd_companion.local_storage.storage_build.storage_setup;

import java.util.Arrays;

import dnd_companion.local_storage.data.structure.options.ArmorCategory;
import dnd_companion.local_storage.data.structure.options.DamageType;
import dnd_companion.local_storage.data.structure.options.DiceType;
import dnd_companion.local_storage.data.structure.options.ItemTag;
import dnd_companion.local_storage.data_build.DataBuilder;
import dnd_companion.local_storage.data_handling.DataHandler;
import dnd_companion.local_storage.system_components.Command;
import dnd_companion.local_storage.system_components.utils.ToolBox;

public class OptionsSetupCommand extends Command
{
	public OptionsSetupCommand execute() {
		try {
			DataHandler.save(DataBuilder.build_options( 
					new ArmorCategory("None"),
					new ArmorCategory("Shield"),
					new ArmorCategory("Light"),
					new ArmorCategory("Medium"),
					new ArmorCategory("Heavy")));
			ToolBox.print("%s: %s", ArmorCategory.GROUP, Arrays.toString(DataHandler.retrieve_options(ArmorCategory.GROUP)));
			
			DataHandler.save(DataBuilder.build_options(
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
					new DiceType("Tetrahedron", "D4", 4),
					new DiceType("Cube", "D6", 6),
					new DiceType("Octahedron", "D8", 8),
					new DiceType("10 Sided Pyramid", "D10", 10),
					new DiceType("Dodecahedron", "D12", 12),
					new DiceType("Icosahedron", "D20", 20)));
			ToolBox.print("%s: %s", DiceType.GROUP, Arrays.toString(DataHandler.retrieve_options(DiceType.GROUP)));

			DataHandler.save(DataBuilder.build_options(
					new ItemTag("Ammunition"),
					new ItemTag("Armor"),
					new ItemTag("Weapon"),
					new ItemTag("Food and Drink"),
					new ItemTag("Adventuring Gear"),
					new ItemTag("Tools"),
					new ItemTag("Instruments")));
			ToolBox.print("%s: %s", ItemTag.GROUP, Arrays.toString(DataHandler.retrieve_options(ItemTag.GROUP)));
			
			this.status = true;
		} catch (Exception e) {
			ToolBox.print_err(e);
			this.status = false;
		}		
		return this;
	}
}
