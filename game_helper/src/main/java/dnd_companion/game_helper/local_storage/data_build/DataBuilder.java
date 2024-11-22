package dnd_companion.game_helper.local_storage.data_build;

import dnd_companion.game_helper.local_storage.data.manipulation.atomic.price.Price;
import dnd_companion.game_helper.local_storage.data.manipulation.atomic.weight.Weight;
import dnd_companion.game_helper.local_storage.data.structure.ArmorData;
import dnd_companion.game_helper.local_storage.data.structure.OptionData;
import dnd_companion.game_helper.local_storage.data.structure.options.ArmorCategory;
import dnd_companion.game_helper.local_storage.data.structure.templates.AtomicOption;

public class DataBuilder 
{
	public static OptionData build_options(String name, AtomicOption... options) {
		return (OptionData) new BuildOptionsCommand(name, options).execute().result();
	}
	
	public static ArmorData build_armor(
		String name, 
		Price price,
		Weight weight,
		String[] tags, 
		String description, 
		ArmorCategory category, 
		int base_armor_class,
		int strength_requirement, 
		boolean stealth_disavantage
	) {
		return (ArmorData) new BuildArmorCommand(
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
