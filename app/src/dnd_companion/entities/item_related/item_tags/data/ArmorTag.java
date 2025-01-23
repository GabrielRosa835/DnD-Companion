package dnd_companion.entities.item_related.item_tags.data;

import dnd_companion.entities.item_related.item_tags.ItemTagCentral;
import dnd_companion.entities.item_related.item_tags.ItemTagEntity;

public final class ArmorTag extends ItemTagEntity
{
	public ArmorTag() {
		super(create());
	}
	private static ArmorTag create() {
		return (ArmorTag) new ItemTagCentral().builder()
				.name("Armor")
				.build();
	}
}
