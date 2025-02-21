package dnd_companion.actors.entities.armor.data;

import dnd_companion.actors.components.measure.Price;
import dnd_companion.actors.components.measure.Weight;
import dnd_companion.actors.entities.armor.Armor;
import dnd_companion.actors.entities.item.Item;
import dnd_companion.actors.entities.system.unit.currency.data.GoldPieces;
import dnd_companion.actors.entities.system.unit.weight.data.Pounds;

public final class LeatherArmor extends Armor
{
	public LeatherArmor() {
		super(Armor.builder()
				.name("Leather Armor")
				.price(new Price(10, new GoldPieces()))
				.weight(new Weight(10, new Pounds()))
				.tags(Item.Tags.ARMOR)
				.category(Armor.Category.LIGHT)
				.armor_class(11)
				.build());
	}
}
