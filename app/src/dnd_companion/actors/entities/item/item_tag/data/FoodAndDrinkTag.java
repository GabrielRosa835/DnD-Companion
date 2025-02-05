package dnd_companion.actors.entities.item.item_tag.data;

import dnd_companion.actors.entities.item.item_tag.ItemTagCentral;
import dnd_companion.actors.entities.item.item_tag.ItemTagEntity;

public class FoodAndDrinkTag extends ItemTagEntity
{
	public FoodAndDrinkTag() {
		super(ItemTagCentral.use().builder()
				.name("Food and drink")
				.build());
	}
}
