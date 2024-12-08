package dnd_companion.local_storage.structure.data.system.units;

import dnd_companion.local_storage.common.ToolBox;

public record LengthUnitData (
	String name, 
	String abbreviation, 
	double normalizing_factor
) implements UnitData {
	public String collection() {return "length_units";}
	public String file_name() {return ToolBox.to_snake_case(this.name);}
	
	public LengthUnitData() {
		this(null, null, 0);
	}
}
