package dnd_companion.entities.item_related.item_tag.data;

import dnd_companion.entities.item_related.item_tag.ItemTagCentral;
import dnd_companion.entities.item_related.item_tag.ItemTagEntity;

public class InstrumentTag extends ItemTagEntity
{
	public InstrumentTag() {
		super(new ItemTagCentral().builder()
				.name("Instrument")
				.build());
	}
}
