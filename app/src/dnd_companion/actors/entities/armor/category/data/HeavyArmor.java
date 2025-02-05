package dnd_companion.actors.entities.armor.category.data;

import dnd_companion.actors.entities.armor.category.ArmorCategoryCentral;
import dnd_companion.actors.entities.armor.category.ArmorCategoryEntity;

public final class HeavyArmor extends ArmorCategoryEntity
{
	public HeavyArmor() {
		super(ArmorCategoryCentral.use().builder()
				.name("Heavy")
				.build());
	}
}