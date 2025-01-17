package dnd_companion.entities.armor_related.armor.data;

import dnd_companion.entities.armor_related.armor.ArmorBuilder;
import dnd_companion.entities.armor_related.armor.ArmorEntity;

public class Unarmored extends ArmorEntity
{
	public Unarmored() {
		super(create());
	}
	private static Unarmored create() {
		return (Unarmored) new ArmorBuilder()
				.name("Unarmored")
				.category("None")
				.armor_class(10)
				.build();
	}
}
