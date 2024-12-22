package dnd_companion.local_storage.structure.data.items.weapons;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.models.data.Data;
import dnd_companion.local_storage.validation.DataValidator;

public record WeaponTypeData (
	String name
) implements Data {
	@Override public String collection() {return "weapon-types";}
	@Override public String file_name() {return ToolBox.to_snake_case(this.name);}
	
	public WeaponTypeData() {
		this(null);
	}
	public WeaponTypeData validate() {
		return (WeaponTypeData) new DataValidator().validate(this).result();
	}
}
