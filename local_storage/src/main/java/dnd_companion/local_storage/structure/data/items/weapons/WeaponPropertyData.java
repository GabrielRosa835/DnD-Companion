package dnd_companion.local_storage.structure.data.items.weapons;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.structure.data.Data;

public record WeaponPropertyData (
	String name,
	String description
) implements Data {
	@Override public String collection() {return "weapon-properties";}
	@Override public String file_name() {return ToolBox.to_snake_case(this.name);}
	
	public WeaponPropertyData() {
		this(null, null);
	}
}
