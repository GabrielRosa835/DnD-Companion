package dnd_companion.local_storage.structure.system.units;

import dnd_companion.common.ToolBox;
import dnd_companion.common.metadata.CollectionREF;
import dnd_companion.common.metadata.Collections;
import dnd_companion.local_storage.structure.models.UnitData;

public record LengthUnitData (
	String name, 
	String plural_name,
	String abbreviation, 
	double normalizing_factor
) implements UnitData {
	public CollectionREF collection() {return Collections.length_units;}
	public String file_name() {return ToolBox.to_snake_case(this.name) + ".json";}
}
