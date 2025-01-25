package dnd_companion.entities.armor_related.armor_category.data;

import dnd_companion.entities.armor_related.armor_category.ArmorCategoryCentral;
import dnd_companion.entities.armor_related.armor_category.ArmorCategoryEntity;

public final class LightArmor extends ArmorCategoryEntity
{
	public LightArmor() {
		super(new ArmorCategoryCentral().builder()
				.name("Light")
				.build());
	}
}