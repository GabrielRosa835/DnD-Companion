package dnd_companion.local_storage.data_build;

import dnd_companion.local_storage.data.manipulation.ItemTags;
import dnd_companion.local_storage.data.manipulation.archived.items.armor.Armor.ArmorCategory;
import dnd_companion.local_storage.data.manipulation.value_group.Price;
import dnd_companion.local_storage.data.manipulation.value_group.Weight;
import dnd_companion.local_storage.data.structure.ArchivedOptionData;
import dnd_companion.local_storage.data.structure.UnitData;
import dnd_companion.local_storage.data.structure.items.armors.ArmorData;
import dnd_companion.local_storage.data.structure.templates.AtomicOption;
import dnd_companion.local_storage.data.structure.templates.AtomicUnit;
import dnd_companion.local_storage.system_components.utils.ToolBox;

public class DataBuilder 
{
	public static ArchivedOptionData build_options(AtomicOption... options) {
		return (ArchivedOptionData) new BuildOptionsCommand(options).execute().result();
	}
	public static UnitData build_units(AtomicUnit... units) {
		return (UnitData) new BuildUnitsCommand(units).execute().result();
	}
	
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
