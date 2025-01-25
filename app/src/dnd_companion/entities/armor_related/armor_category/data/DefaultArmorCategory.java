package dnd_companion.entities.armor_related.armor_category.data;

import dnd_companion.entities.armor_related.armor_category.ArmorCategoryCentral;
import dnd_companion.entities.armor_related.armor_category.ArmorCategoryEntity;

public class DefaultArmorCategory extends ArmorCategoryEntity
{
	public DefaultArmorCategory() {
		super(new ArmorCategoryCentral().builder().build());
	}
}
