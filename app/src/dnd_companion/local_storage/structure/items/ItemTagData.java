package dnd_companion.local_storage.structure.items;

import dnd_companion.common.ToolBox;
import dnd_companion.common.metadata.CollectionREF;
import dnd_companion.common.metadata.Collections;
import dnd_companion.local_storage.structure.models.Data;

public record ItemTagData (
	String name
) implements Data {
	@Override public CollectionREF collection() {return Collections.item_tags;}
	@Override public String file_name() {return ToolBox.to_snake_case(this.name) + ".json";}
}
