package dnd_companion.entities.item_related.item_tag.data;

import dnd_companion.entities.item_related.item_tag.ItemTagCentral;
import dnd_companion.entities.item_related.item_tag.ItemTagEntity;

public class ToolTag extends ItemTagEntity
{
	public ToolTag() {
		super(new ItemTagCentral().builder()
				.name("Tool")
				.build());
	}
}
