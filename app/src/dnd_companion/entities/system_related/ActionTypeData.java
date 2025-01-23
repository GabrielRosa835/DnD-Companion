package dnd_companion.entities.system_related;

import dnd_companion.archives.local_storage.structure.models.Data;
import dnd_companion.common.metadata.CollectionREF;
import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;

public record ActionTypeData (
	String name
) implements Data {
	private static CollectionsMetadata collections = new CollectionsMetadata();
	private static ToolBox tools = new ToolBox();
	
	@Override public CollectionREF collection() {return collections.action_types();}
	@Override public String file_name() {return tools.toFileName(this.name);}
}
