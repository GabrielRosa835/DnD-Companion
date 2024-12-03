package dnd_companion.local_storage.data_structure.java.items.armors;

import dnd_companion.local_storage.data_structure.java.items.GenericItem;
import dnd_companion.local_storage.data_structure.java.items.ItemTag;
import dnd_companion.local_storage.data_structure.java.system.units.Price;
import dnd_companion.local_storage.data_structure.java.system.units.Weight;

public class Armor extends GenericItem
{
	public ArmorCategory category;
	public int armor_class;
	public int strength_requirement;
	public boolean stealth_disadvantage;

	public Armor(
		String name,
		Price price,
		Weight weight,
		ItemTag[] tags,
		String description,
		ArmorCategory category,
		int armor_class,
		int strength_requirement,
		boolean stealth_disadvantage
	) {
		super(name, price, weight, tags, description);
		this.category = category;
		this.armor_class = armor_class;
		this.strength_requirement = strength_requirement;
		this.stealth_disadvantage = stealth_disadvantage;
	}
}
