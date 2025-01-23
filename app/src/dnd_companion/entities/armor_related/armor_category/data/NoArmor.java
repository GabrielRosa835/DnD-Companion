package dnd_companion.entities.armor_related.armor_category.data;

import dnd_companion.entities.armor_related.armor_category.ArmorCategoryCentral;
import dnd_companion.entities.armor_related.armor_category.ArmorCategoryEntity;

public final class NoArmor extends ArmorCategoryEntity
{
	public NoArmor() {
		super(create());
	}
	private static NoArmor create() {
		return (NoArmor) new ArmorCategoryCentral().builder()
				.name("Unarmored")
				.build();
	}
}
