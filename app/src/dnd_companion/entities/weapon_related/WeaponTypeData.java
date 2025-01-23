package dnd_companion.entities.weapon_related;

import dnd_companion.archives.local_storage.structure.models.Data;
import dnd_companion.common.metadata.CollectionREF;

public record WeaponTypeData (
	String name
) implements Data {
	@Override public CollectionREF collection() {return collections.weapon_types();}
	@Override public String file_name() {return tools.toFileName(this.name);}
}
