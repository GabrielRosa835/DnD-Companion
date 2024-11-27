package dnd_companion.local_storage.data_build;

import dnd_companion.local_storage.data.manipulation.value_group.Price;
import dnd_companion.local_storage.data.manipulation.value_group.Weight;
import dnd_companion.local_storage.data.structure.items.armors.ArmorData;
import dnd_companion.local_storage.system_components.utils.ToolBox;

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
		return new BuildArmorCommand(
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
