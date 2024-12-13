package dnd_companion.local_storage.structure.data.items.weapons;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.structure.data.ItemData;
import dnd_companion.local_storage.validation.DataValidator;

public record WeaponCategoryData (
	String name
) implements ItemData {
	@Override public String collection() {return "weapon-categories";}
	@Override public String file_name() {return ToolBox.to_snake_case(this.name);}
	
	public WeaponCategoryData() {
		this(null);
	}
	public WeaponCategoryData validate() {
		return (WeaponCategoryData) new DataValidator().validate(this).result();
	}
}
