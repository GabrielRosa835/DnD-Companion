package dnd_companion.local_storage.structure.items.armors;

import dnd_companion.common.metadata.CollectionREF;
import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.local_storage.structure.models.Data;

public record ArmorCategoryData (
	String name,
	double don_time_value,
	String don_time_unit,
	double doff_time_value,
	String doff_time_unit
) implements Data {
	private static CollectionsMetadata collections = new CollectionsMetadata();
	private static ToolBox tools = new ToolBox();
	
	@Override public CollectionREF collection() {return collections.armor_categories();}
	@Override public String file_name() {return tools.to_snake_case(this.name) + ".json";}
}
