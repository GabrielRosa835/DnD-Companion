package dnd_companion.archives.local_storage.structure.system;

import dnd_companion.archives.local_storage.structure.models.Data;
import dnd_companion.common.metadata.CollectionREF;
import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;

public record DiceTypeData (
	int max_value
) implements Data {
	private static CollectionsMetadata collections = new CollectionsMetadata();
	private static ToolBox tools = new ToolBox();
	
	@Override public CollectionREF collection() {return collections.dice_types();}
	@Override public String file_name() {return tools.toFileName(this.name());}
	
	public String name() {return String.format("D%d", this.max_value);}
}
