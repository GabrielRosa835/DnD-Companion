package dnd_companion.local_storage.structure.items;

import dnd_companion.common.metadata.CollectionREF;
import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.local_storage.structure.models.Data;

public record ItemTagData (
	String name
) implements Data {
	private static CollectionsMetadata collections = new CollectionsMetadata();
	private static ToolBox tools = new ToolBox();
	
	@Override public CollectionREF collection() {return collections.item_tags();}
	@Override public String file_name() {return tools.to_snake_case(this.name) + ".json";}
}
