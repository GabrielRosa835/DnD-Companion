package dnd_companion.local_storage.data.structure.items.armors;

import dnd_companion.local_storage.data.manipulation.value_group.Price;
import dnd_companion.local_storage.data.manipulation.value_group.Weight;
import dnd_companion.local_storage.data.structure.templates.ItemData;

public record ArmorData(
	String name,
	Price price,
	Weight weight,
	String[] tags,
	String description,
	String category,
	int base_armor_class,
	int strength_requirement,
	boolean stealth_disadvantage
) implements ItemData {
	public String collection() {return "armors";}
}
