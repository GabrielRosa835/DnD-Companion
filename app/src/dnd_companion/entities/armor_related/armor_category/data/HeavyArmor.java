package dnd_companion.entities.armor_related.armor_category.data;

import dnd_companion.entities.armor_related.armor_category.ArmorCategoryCentral;
import dnd_companion.entities.armor_related.armor_category.ArmorCategoryEntity;

public final class HeavyArmor extends ArmorCategoryEntity
{	
	public HeavyArmor() {
		super(create());
	}
	private static HeavyArmor create() {
		return (HeavyArmor) new ArmorCategoryCentral().builder()
				.name("Heavy")
				.build();
	}
}