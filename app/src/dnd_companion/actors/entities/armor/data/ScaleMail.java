package dnd_companion.actors.entities.armor.data;

import dnd_companion.actors.components.measure.Price;
import dnd_companion.actors.components.measure.Weight;
import dnd_companion.actors.entities.armor.Armor;
import dnd_companion.actors.entities.item.Item;
import dnd_companion.actors.entities.system.unit.currency.data.GoldPieces;
import dnd_companion.actors.entities.system.unit.weight.data.Pounds;

public final class ScaleMail extends Armor
{
	public ScaleMail() {
		super(Armor.builder()
				.name("Scale Mail")
				.price(new Price(50, new GoldPieces()))
				.weight(new Weight(45, new Pounds()))
				.tags(Item.Tags.ARMOR)
				.category(Armor.Category.MEDIUM)
				.armor_class(14)
				.stealth_disadvantage(true)
				.build());
	}
}
