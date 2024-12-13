package dnd_companion.local_storage.structure.data.items.weapons;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.structure.data.ItemData;
import dnd_companion.local_storage.validation.DataValidator;

public record WeaponPropertyData (
	String name,
	String description
) implements ItemData {
	@Override public String collection() {return "weapon-properties";}
	@Override public String file_name() {return ToolBox.to_snake_case(this.name);}
	
	public WeaponPropertyData() {
		this(null, null);
	}
	public WeaponPropertyData validate() {
		return (WeaponPropertyData) new DataValidator().validate(this).result();
	}
}
