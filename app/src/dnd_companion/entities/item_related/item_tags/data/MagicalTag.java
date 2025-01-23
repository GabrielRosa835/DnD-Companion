package dnd_companion.entities.item_related.item_tags.data;

import dnd_companion.entities.item_related.item_tags.ItemTagCentral;
import dnd_companion.entities.item_related.item_tags.ItemTagEntity;

public final class MagicalTag extends ItemTagEntity
{
	public MagicalTag() {
		super(create());
	}
	private static MagicalTag create() {
		return (MagicalTag) new ItemTagCentral().builder()
				.name("Magical")
				.build();
	}
}
