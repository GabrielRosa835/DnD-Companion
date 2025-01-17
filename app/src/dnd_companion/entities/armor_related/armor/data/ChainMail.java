package dnd_companion.entities.armor_related.armor.data;

import dnd_companion.entities.armor_related.armor.ArmorBuilder;
import dnd_companion.entities.armor_related.armor.ArmorEntity;

public class ChainMail extends ArmorEntity
{
	public ChainMail() {
		super(create());
	}
	private static ChainMail create() {
		return (ChainMail) new ArmorBuilder()
				.name("Chain Mail")
				.price(75, "gp")
				.weight(55, "lbs")
				.tags("Armor")
				.category("Heavy")
				.armor_class(16)
				.strength_requirement(13)
				.stealth_disadvantage(true)
				.build();
	}
}
