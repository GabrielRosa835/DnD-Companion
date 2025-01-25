package dnd_companion.entities.weapon_related;

import javax.xml.crypto.Data;

import dnd_companion.common.metadata.CollectionREF;

public record WeaponMasteryData (
	String name,
	String description
) implements Data {
	@Override public CollectionREF collection() {return collections.weapon_masteries();}
	@Override public String file_name() {return tools.toFileName(this.name);}
}
