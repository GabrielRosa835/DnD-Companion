package dnd_companion.local_storage.structure.data.items.weapons;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.structure.data.Data;
import dnd_companion.local_storage.validation.DataValidator;

public record WeaponMasteryData (
	String name,
	String description
) implements Data {
	@Override public String collection() {return "weapon-masteries";}
	@Override public String file_name() {return ToolBox.to_snake_case(this.name);}
	
	public WeaponMasteryData() {
		this(null, null);
	}
	public WeaponMasteryData validate() {
		return (WeaponMasteryData) new DataValidator().validate(this).result();
	}
}
