package dnd_companion.actors.entities.item.item_tag.data;

import dnd_companion.actors.entities.item.item_tag.ItemTagCentral;
import dnd_companion.actors.entities.item.item_tag.ItemTagEntity;

public final class AmmunitionTag extends ItemTagEntity
{
	public AmmunitionTag() {
		super(ItemTagCentral.use().builder()
				.name("Ammunition")
				.build());
	}
}
