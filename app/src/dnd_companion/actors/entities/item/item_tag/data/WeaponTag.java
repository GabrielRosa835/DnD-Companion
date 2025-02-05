package dnd_companion.actors.entities.item.item_tag.data;

import dnd_companion.actors.entities.item.item_tag.ItemTagCentral;
import dnd_companion.actors.entities.item.item_tag.ItemTagEntity;

public final class WeaponTag extends ItemTagEntity
{
	public WeaponTag() {
		super(ItemTagCentral.use().builder()
				.name("Weapon")
				.build());
	}
}
