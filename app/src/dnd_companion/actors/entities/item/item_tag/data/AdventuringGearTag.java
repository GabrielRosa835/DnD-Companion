package dnd_companion.actors.entities.item.item_tag.data;

import dnd_companion.actors.entities.item.item_tag.ItemTagCentral;
import dnd_companion.actors.entities.item.item_tag.ItemTagEntity;

public class AdventuringGearTag extends ItemTagEntity
{
	public AdventuringGearTag() {
		super(ItemTagCentral.use().builder()
				.name("Adventuring gear")
				.build());
	}
}
