package dnd_companion.local_storage.structure.data.system.units;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.structure.data.UnitData;
import dnd_companion.local_storage.validation.DataValidator;

public record TimeUnitData (
	String name,
	String abbreviation,
	double normalizing_factor
) implements UnitProperties, UnitData {
	@Override public String collection() {return "time-step-types";}
	@Override public String file_name() {return ToolBox.to_snake_case(this.name);}
	
	public TimeUnitData() {
		this(null, null, 0);
	}
	public TimeUnitData validate() {
		return (TimeUnitData) new DataValidator().validate(this).result();
	}
}
