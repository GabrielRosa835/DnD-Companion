package dnd_companion.entities.armor_related.armor.data;

import dnd_companion.entities.armor_related.armor.ArmorCentral;
import dnd_companion.entities.armor_related.armor.ArmorEntity;
import dnd_companion.entities.armor_related.armor_category.data.HeavyArmor;
import dnd_companion.entities.item_related.item_tags.data.ArmorTag;
import dnd_companion.entities.unit_related.currency.data.GoldPieces;
import dnd_companion.entities.unit_related.weight.data.Pounds;

public final class ChainMail extends ArmorEntity
{
	public ChainMail() {
		super(create());
	}
	private static ChainMail create() {
		return (ChainMail) new ArmorCentral().builder()
				.name("Chain Mail")
				.price(75, new GoldPieces())
				.weight(55, new Pounds())
				.tags(new ArmorTag())
				.category(new HeavyArmor())
				.armor_class(16)
				.strength_requirement(13)
				.stealth_disadvantage(true)
				.build();
	}
}
