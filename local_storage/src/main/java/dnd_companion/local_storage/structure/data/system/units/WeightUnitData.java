package dnd_companion.local_storage.structure.data.system.units;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.models.data.UnitData;
import dnd_companion.local_storage.validation.DataValidator;

public record WeightUnitData (
	String name, 
	String plural_name,
	String abbreviation, 
	double normalizing_factor
) implements UnitData {
	public String collection() {return "weight_units";}
	public String file_name() {return ToolBox.to_snake_case(this.name);}
	
	public WeightUnitData() {
		this(null, null, null, 0);
	}
	public WeightUnitData validate() {
		return (WeightUnitData) new DataValidator().validate(this).result();
	}
}
