package dnd_companion.actors.entities.item.item_tag.data;

import dnd_companion.actors.entities.item.item_tag.ItemTagCentral;
import dnd_companion.actors.entities.item.item_tag.ItemTagEntity;

public final class MagicalTag extends ItemTagEntity
{
	public MagicalTag() {
		super(ItemTagCentral.use().builder()
				.name("Magical")
				.build());
	}
}
