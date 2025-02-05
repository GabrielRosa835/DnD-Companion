package dnd_companion.actors.entities.item.item_tag.data;

import dnd_companion.actors.entities.item.item_tag.ItemTagCentral;
import dnd_companion.actors.entities.item.item_tag.ItemTagEntity;

public class InstrumentTag extends ItemTagEntity
{
	public InstrumentTag() {
		super(ItemTagCentral.use().builder()
				.name("Instrument")
				.build());
	}
}
