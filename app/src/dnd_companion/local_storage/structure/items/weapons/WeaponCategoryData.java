package dnd_companion.local_storage.structure.items.weapons;

import dnd_companion.common.metadata.CollectionREF;
import dnd_companion.local_storage.structure.models.Data;

public record WeaponCategoryData (
	String name
) implements Data {
	@Override public CollectionREF collection() {return collections.weapon_categories();}
	@Override public String file_name() {return tools.toFileName(this.name);}
}
