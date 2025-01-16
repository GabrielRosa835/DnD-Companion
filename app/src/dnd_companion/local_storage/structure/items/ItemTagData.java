package dnd_companion.local_storage.structure.items;

import dnd_companion.common.metadata.CollectionREF;
import dnd_companion.local_storage.structure.models.Data;

public record ItemTagData (
	String name
) implements Data {
	@Override public CollectionREF collection() {return collections.item_tags();}
	@Override public String file_name() {return tools.toFileName(this.name);}
}
