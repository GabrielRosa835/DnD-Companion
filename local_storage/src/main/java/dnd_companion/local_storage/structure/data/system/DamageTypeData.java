package dnd_companion.local_storage.structure.data.system;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.models.data.Data;
import dnd_companion.local_storage.validation.DataValidator;

public record DamageTypeData (
	String name
) implements Data {
	@Override public String collection() {return "damage-types";}
	@Override public String file_name() {return ToolBox.to_snake_case(this.name);}
	
	public DamageTypeData() {
		this(null);
	}
	public DamageTypeData validate() {
		return (DamageTypeData) new DataValidator().validate(this).result();
	}
}
