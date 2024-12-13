package dnd_companion.local_storage.structure.data.system.units;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.structure.data.UnitData;
import dnd_companion.local_storage.validation.DataValidator;

public record CurrencyUnitData (
	String name, 
	String abbreviation, 
	double normalizing_factor
) implements UnitProperties, UnitData {	
	public String collection() {return "currencies";}
	public String file_name() {return ToolBox.to_snake_case(this.name);}
	
	public CurrencyUnitData() {
		this(null, null, 0);
	}
	public CurrencyUnitData validate() {
		return (CurrencyUnitData) new DataValidator().validate(this).result();
	}
}
