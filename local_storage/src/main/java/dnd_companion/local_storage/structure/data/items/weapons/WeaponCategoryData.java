package dnd_companion.local_storage.structure.data.items.weapons;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.structure.data.Data;

public record WeaponCategoryData (
	String name
) implements Data {
	@Override public String collection() {return "weapon-categories";}
	@Override public String file_name() {return ToolBox.to_snake_case(this.name);}
	
	public WeaponCategoryData() {
		this(null);
	}
}
