package dnd_companion.local_storage.structure.items.weapons;

import dnd_companion.common.metadata.CollectionREF;
import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.local_storage.structure.models.Data;

public record WeaponPropertyData (
	String name,
	String description
) implements Data {
	@Override public CollectionREF collection() {return new CollectionsMetadata().weapon_properties;}
	@Override public String file_name() {return ToolBox.to_snake_case(this.name) + ".json";}
}
