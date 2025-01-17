package dnd_companion.archives.local_storage.structure.items.weapons;

import dnd_companion.archives.local_storage.structure.models.Data;
import dnd_companion.common.metadata.CollectionREF;

public record WeaponMasteryData (
	String name,
	String description
) implements Data {
	@Override public CollectionREF collection() {return collections.weapon_masteries();}
	@Override public String file_name() {return tools.toFileName(this.name);}
}
