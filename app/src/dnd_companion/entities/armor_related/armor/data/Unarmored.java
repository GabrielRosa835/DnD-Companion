package dnd_companion.entities.armor_related.armor.data;

import dnd_companion.entities.armor_related.armor.ArmorCentral;
import dnd_companion.entities.armor_related.armor.ArmorEntity;
import dnd_companion.entities.armor_related.armor_category.data.NoArmor;

public final class Unarmored extends ArmorEntity
{
	public Unarmored() {
		super(new ArmorCentral().builder()
				.name("Unarmored")
				.category(new NoArmor())
				.build());
	}
}
