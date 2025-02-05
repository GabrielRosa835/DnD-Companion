package dnd_companion.actors.entities.armor.category.data;

import dnd_companion.actors.entities.armor.category.ArmorCategoryCentral;
import dnd_companion.actors.entities.armor.category.ArmorCategoryEntity;

public final class LightArmor extends ArmorCategoryEntity
{
	public LightArmor() {
		super(ArmorCategoryCentral.use().builder()
				.name("Light")
				.build());
	}
}