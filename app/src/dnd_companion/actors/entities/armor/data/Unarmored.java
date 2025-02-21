package dnd_companion.actors.entities.armor.data;

import dnd_companion.actors.entities.armor.Armor;

public final class Unarmored extends Armor
{
	public Unarmored() {
		super(Armor.builder()
				.name("Unarmored")
				.category(Armor.Category.UNARMORED)
				.build());
	}
}
