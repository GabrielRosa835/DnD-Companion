package dnd_companion.entities.item_related.item_tag.data;

import dnd_companion.entities.item_related.item_tag.ItemTagCentral;
import dnd_companion.entities.item_related.item_tag.ItemTagEntity;

public class AdventuringGearTag extends ItemTagEntity
{
	public AdventuringGearTag() {
		super(new ItemTagCentral().builder()
				.name("Adventuring gear")
				.build());
	}
}
