package dnd_companion.entities.item_related.item_tags.data;

import dnd_companion.entities.item_related.item_tags.ItemTagCentral;
import dnd_companion.entities.item_related.item_tags.ItemTagEntity;

public final class WeaponTag extends ItemTagEntity
{
	public WeaponTag() {
		super(create());
	}
	private static WeaponTag create() {
		return (WeaponTag) new ItemTagCentral().builder()
				.name("Weapon")
				.build();
	}
}
