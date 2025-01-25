package dnd_companion.entities.item_related.item_tag.data;

import dnd_companion.entities.item_related.item_tag.ItemTagCentral;
import dnd_companion.entities.item_related.item_tag.ItemTagEntity;

public class FoodAndDrinkTag extends ItemTagEntity
{
	public FoodAndDrinkTag() {
		super(new ItemTagCentral().builder()
				.name("Food and drink")
				.build());
	}
}
