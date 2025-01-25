package dnd_companion.entities.armor_related.armor_category.data;

import dnd_companion.entities.armor_related.armor_category.ArmorCategoryCentral;
import dnd_companion.entities.armor_related.armor_category.ArmorCategoryEntity;

public final class HeavyArmor extends ArmorCategoryEntity
{
	public HeavyArmor() {
		super(new ArmorCategoryCentral().builder()
				.name("Heavy")
				.build());
	}
}