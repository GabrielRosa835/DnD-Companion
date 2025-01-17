package dnd_companion.entities.armor_related.armor.data;

import dnd_companion.entities.armor_related.armor.ArmorBuilder;
import dnd_companion.entities.armor_related.armor.ArmorEntity;

public class ScaleMail extends ArmorEntity
{
	public ScaleMail() {
		super(create());
	}
	private static ScaleMail create() {
		return (ScaleMail) new ArmorBuilder()
				.name("Scale Mail")
				.price(50, "gp")
				.weight(45, "lbs")
				.tags("Armor")
				.category("Medium")
				.armor_class(14)
				.stealth_disadvantage(true)
				.build();
	}
}
