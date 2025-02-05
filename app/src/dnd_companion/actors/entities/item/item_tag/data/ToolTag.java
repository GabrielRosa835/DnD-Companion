package dnd_companion.actors.entities.item.item_tag.data;

import dnd_companion.actors.entities.item.item_tag.ItemTagCentral;
import dnd_companion.actors.entities.item.item_tag.ItemTagEntity;

public class ToolTag extends ItemTagEntity
{
	public ToolTag() {
		super(ItemTagCentral.use().builder()
				.name("Tool")
				.build());
	}
}
