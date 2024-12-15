package dnd_companion.local_storage.structure.data.system.units;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.structure.data.UnitData;
import dnd_companion.local_storage.validation.DataValidator;

public record LengthUnitData (
	String name, 
	String plural_name,
	String abbreviation, 
	double normalizing_factor
) implements UnitData {
	public String collection() {return "length_units";}
	public String file_name() {return ToolBox.to_snake_case(this.name);}
	
	public LengthUnitData() {
		this(null, null, null, 0);
	}
	public LengthUnitData validate() {
		return (LengthUnitData) new DataValidator().validate(this).result();
	}
}
