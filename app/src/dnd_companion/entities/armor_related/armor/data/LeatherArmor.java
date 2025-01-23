package dnd_companion.entities.armor_related.armor.data;

import dnd_companion.entities.armor_related.armor.ArmorCentral;
import dnd_companion.entities.armor_related.armor.ArmorEntity;
import dnd_companion.entities.armor_related.armor_category.data.LightArmor;
import dnd_companion.entities.item_related.item_tags.data.ArmorTag;
import dnd_companion.entities.unit_related.currency.data.GoldPieces;
import dnd_companion.entities.unit_related.weight.data.Pounds;

public final class LeatherArmor extends ArmorEntity
{
	public LeatherArmor() {
		super(create());
	}
	private static LeatherArmor create() {
		return (LeatherArmor) new ArmorCentral().builder()
				.name("Leather Armor")
				.price(10, new GoldPieces())
				.weight(10, new Pounds())
				.tags(new ArmorTag())
				.category(new LightArmor())
				.armor_class(11)
				.build();
	}
}
