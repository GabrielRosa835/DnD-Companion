package dnd_companion.local_storage.structure.system.units;

import dnd_companion.common.metadata.CollectionREF;
import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.local_storage.structure.models.UnitData;

public record WeightUnitData (
	String name, 
	String plural_name,
	String abbreviation, 
	double normalizing_factor
) implements UnitData {
	@Override public CollectionREF collection() {return new CollectionsMetadata().weight_units;}
	@Override public String file_name() {return ToolBox.to_snake_case(this.name) + ".json";}
}
