package dnd_companion.entities.armor_related.armor.data;

import dnd_companion.entities.armor_related.armor.ArmorBuilder;
import dnd_companion.entities.armor_related.armor.ArmorEntity;

public class LeatherArmor extends ArmorEntity
{
	public LeatherArmor() {
		super(create());
	}
	private static LeatherArmor create() {
		return (LeatherArmor) new ArmorBuilder()
				.name("Leather Armor")
				.price(10, "gp")
				.weight(10, "lbs")
				.tags("Armor")
				.category("Light")
				.armor_class(11)
				.build();
	}
}
