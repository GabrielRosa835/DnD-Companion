package dnd_companion.actors.entities.armor.category.data;

import dnd_companion.actors.entities.armor.category.ArmorCategoryCentral;
import dnd_companion.actors.entities.armor.category.ArmorCategoryEntity;

public final class MediumArmor extends ArmorCategoryEntity
{
	public MediumArmor() {
		super(ArmorCategoryCentral.use().builder()
				.name("Medium")
				.build());
	}
}
