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
	@Override public CollectionREF collection() {return new CollectionsMetadata().armor_categories;}
	@Override public String file_name() {return ToolBox.to_snake_case(this.name) + ".json";}
}
