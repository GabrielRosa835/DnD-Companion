package dnd_companion.local_storage.structure.components.items.armors;

import dnd_companion.local_storage.structure.components.items.GenericItem;
import dnd_companion.local_storage.structure.components.items.ItemTag;
import dnd_companion.local_storage.structure.components.system.units.Price;
import dnd_companion.local_storage.structure.components.system.units.Weight;

public class ArmorComponent extends GenericItem
{
	public ArmorCategoryComponent category;
	public int armor_class;
	public int strength_requirement;
	public boolean stealth_disadvantage;

	public ArmorComponent(
		String name,
		Price price,
		Weight weight,
		ItemTag[] tags,
		String description,
		ArmorCategoryComponent category,
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
