package dnd_companion.local_storage.structure.items.weapons;

import dnd_companion.common.metadata.CollectionREF;
import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.local_storage.structure.models.Data;

public record WeaponMasteryData (
	String name,
	String description
) implements Data {
	@Override public CollectionREF collection() {return new CollectionsMetadata().weapon_masteries;}
	@Override public String file_name() {return ToolBox.to_snake_case(this.name) + ".json";}
}
