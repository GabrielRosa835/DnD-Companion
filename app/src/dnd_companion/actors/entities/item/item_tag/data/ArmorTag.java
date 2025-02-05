package dnd_companion.actors.entities.item.item_tag.data;

import dnd_companion.actors.entities.item.item_tag.ItemTagCentral;
import dnd_companion.actors.entities.item.item_tag.ItemTagEntity;

public final class ArmorTag extends ItemTagEntity
{
	public ArmorTag() {
		super(ItemTagCentral.use().builder()
				.name("Armor")
				.build());
	}
}
