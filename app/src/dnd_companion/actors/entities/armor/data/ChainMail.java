package dnd_companion.actors.entities.armor.data;

import dnd_companion.actors.components.measure.Price;
import dnd_companion.actors.components.measure.Weight;
import dnd_companion.actors.entities.armor.Armor;
import dnd_companion.actors.entities.item.Item;
import dnd_companion.actors.entities.system.unit.currency.data.GoldPieces;
import dnd_companion.actors.entities.system.unit.weight.data.Pounds;

public final class ChainMail extends Armor
{
	public ChainMail() {
		super(Armor.builder()
				.name("Chain Mail")
				.price(new Price(75, new GoldPieces()))
				.weight(new Weight(55, new Pounds()))
				.tags(Item.Tags.ARMOR)
				.category(Armor.Category.HEAVY)
				.armor_class(16)
				.strength_requirement(13)
				.stealth_disadvantage(true)
				.build());
	}
}
