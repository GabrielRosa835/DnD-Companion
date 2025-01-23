package dnd_companion.entities.armor_related.armor.data;

import dnd_companion.entities.armor_related.armor.ArmorCentral;
import dnd_companion.entities.armor_related.armor.ArmorEntity;
import dnd_companion.entities.armor_related.armor_category.data.MediumArmor;
import dnd_companion.entities.item_related.item_tags.data.ArmorTag;
import dnd_companion.entities.unit_related.currency.data.GoldPieces;
import dnd_companion.entities.unit_related.weight.data.Pounds;

public final class ScaleMail extends ArmorEntity
{
	public ScaleMail() {
		super(create());
	}
	private static ScaleMail create() {
		return (ScaleMail) new ArmorCentral().builder()
				.name("Scale Mail")
				.price(50, new GoldPieces())
				.weight(45, new Pounds())
				.tags(new ArmorTag())
				.category(new MediumArmor())
				.armor_class(14)
				.stealth_disadvantage(true)
				.build();
	}
}
