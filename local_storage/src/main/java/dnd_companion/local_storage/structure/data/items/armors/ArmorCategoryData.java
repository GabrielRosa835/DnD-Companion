package dnd_companion.local_storage.structure.data.items.armors;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.structure.data.Data;
import dnd_companion.local_storage.validation.DataValidator;

public record ArmorCategoryData (
	String name,
	double don_time,
	String don_time_unit,
	double doff_time,
	String doff_time_unit
) implements Data {
	@Override public String collection() {return "armor-categories";}
	@Override public String file_name() {return ToolBox.to_snake_case(this.name);}
	
	public ArmorCategoryData() {
		this(null, 0, null, 0, null);
	}
	public ArmorCategoryData validate() {
		return (ArmorCategoryData) new DataValidator().validate(this).result();
	}
}
