package dnd_companion.actors.entities.armor.data;

import dnd_companion.actors.components.measure.Price;
import dnd_companion.actors.components.measure.Weight;
import dnd_companion.actors.entities.armor.ArmorCentral;
import dnd_companion.actors.entities.armor.ArmorEntity;
import dnd_companion.actors.entities.armor.category.data.MediumArmor;
import dnd_companion.actors.entities.item.item_tag.data.ArmorTag;
import dnd_companion.actors.entities.system.unit.currency.data.GoldPieces;
import dnd_companion.actors.entities.system.unit.weight.data.Pounds;

public final class ScaleMail extends ArmorEntity
{
	public ScaleMail() {
		super(ArmorCentral.use().builder()
				.name("Scale Mail")
				.price(new Price(50, new GoldPieces()))
				.weight(new Weight(45, new Pounds()))
				.tags(new ArmorTag())
				.category(new MediumArmor())
				.armor_class(14)
				.stealth_disadvantage(true)
				.build());
	}
}
