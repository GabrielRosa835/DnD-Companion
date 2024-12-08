package dnd_companion.local_storage.structure.data.system.units;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.structure.data.Data;

public record TimeUnitData (
	String name,
	String abbreviation,
	double normalizing_factor
) implements UnitProperties, Data {
	@Override public String collection() {return "time-step-types";}
	@Override public String file_name() {return ToolBox.to_snake_case(this.name);}
	
	public TimeUnitData() {
		this(null, null, 0);
	}
}
