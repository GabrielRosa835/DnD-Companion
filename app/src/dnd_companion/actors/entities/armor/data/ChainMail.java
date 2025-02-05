package dnd_companion.actors.entities.armor.data;

import dnd_companion.actors.components.measure.Price;
import dnd_companion.actors.components.measure.Weight;
import dnd_companion.actors.entities.armor.ArmorCentral;
import dnd_companion.actors.entities.armor.ArmorEntity;
import dnd_companion.actors.entities.armor.category.data.HeavyArmor;
import dnd_companion.actors.entities.item.item_tag.data.ArmorTag;
import dnd_companion.actors.entities.system.unit.currency.data.GoldPieces;
import dnd_companion.actors.entities.system.unit.weight.data.Pounds;

public final class ChainMail extends ArmorEntity
{
	public ChainMail() {
		super(ArmorCentral.use().builder()
				.name("Chain Mail")
				.price(new Price(75, new GoldPieces()))
				.weight(new Weight(55, new Pounds()))
				.tags(new ArmorTag())
				.category(new HeavyArmor())
				.armor_class(16)
				.strength_requirement(13)
				.stealth_disadvantage(true)
				.build());
	}
}
