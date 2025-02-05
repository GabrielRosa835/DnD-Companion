package dnd_companion.actors.entities.armor.data;

import dnd_companion.actors.entities.armor.ArmorCentral;
import dnd_companion.actors.entities.armor.ArmorEntity;
import dnd_companion.actors.entities.armor.category.data.NoArmor;

public final class Unarmored extends ArmorEntity
{
	public Unarmored() {
		super(ArmorCentral.use().builder()
				.name("Unarmored")
				.category(new NoArmor())
				.build());
	}
}
