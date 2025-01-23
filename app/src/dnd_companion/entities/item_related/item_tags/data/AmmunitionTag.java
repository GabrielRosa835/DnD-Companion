package dnd_companion.entities.item_related.item_tags.data;

import dnd_companion.entities.item_related.item_tags.ItemTagCentral;
import dnd_companion.entities.item_related.item_tags.ItemTagEntity;

public final class AmmunitionTag extends ItemTagEntity
{
	public AmmunitionTag() {
		super(create());
	}
	private static AmmunitionTag create() {
		return (AmmunitionTag) new ItemTagCentral().builder()
				.name("Ammunition")
				.build();
	}
}
