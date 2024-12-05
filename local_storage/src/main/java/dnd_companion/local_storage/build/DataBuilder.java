package dnd_companion.local_storage.build;

import dnd_companion.local_storage.build.armor.BuildArmorDataCommand;
import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.structure.components.system.units.Price;
import dnd_companion.local_storage.structure.components.system.units.Weight;
import dnd_companion.local_storage.structure.data.items.armors.ArmorData;

public class DataBuilder
{
	public static ArmorData build_armor(
		String name,
		Price price,
		Weight weight,
		String[] tags,
		String description,
		String category,
		int base_armor_class,
		int strength_requirement,
		boolean stealth_disavantage
	) {
		ToolBox.print("Reached here: %s", DataBuilder.class.getName());
		return new BuildArmorDataCommand(
			name,
			price,
			weight,
			tags,
			description,
			category,
			base_armor_class,
			strength_requirement,
			stealth_disavantage
		).execute().result();
	}
}
