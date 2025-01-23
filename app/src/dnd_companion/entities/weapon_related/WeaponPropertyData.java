package dnd_companion.entities.weapon_related;

import dnd_companion.archives.local_storage.structure.models.Data;
import dnd_companion.common.metadata.CollectionREF;

public record WeaponPropertyData (
	String name,
	String description
) implements Data {
	@Override public CollectionREF collection() {return collections.weapon_properties();}
	@Override public String file_name() {return tools.toFileName(this.name);}
}
