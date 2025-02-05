package dnd_companion.actors.entities.item.weapons.category;

import javax.xml.crypto.Data;

import dnd_companion.common.metadata.CollectionREF;

public record WeaponCategoryData (
	String name
) implements Data {
	@Override public CollectionREF collection() {return collections.weapon_categories();}
	@Override public String file_name() {return tools.toFileName(this.name);}
}
