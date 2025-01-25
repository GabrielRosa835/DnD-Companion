package dnd_companion.entities.item_related.item_tag.data;

import dnd_companion.entities.item_related.item_tag.ItemTagCentral;
import dnd_companion.entities.item_related.item_tag.ItemTagEntity;

public final class AmmunitionTag extends ItemTagEntity
{
	public AmmunitionTag() {
		super(new ItemTagCentral().builder()
				.name("Ammunition")
				.build());
	}
}
