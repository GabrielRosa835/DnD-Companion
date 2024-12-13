package dnd_companion.local_storage.structure.data.items;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.validation.DataValidator;

public record GenericItemData(
	String name,
	double price_value,
	String price_unit,
	double weight_value,
	String weight_unit,
	String[] tags,
	String description
) implements ItemProperties {
	@Override public String collection() {return "items";}
	@Override public String file_name() {return ToolBox.to_snake_case(this.name);}
	
	public GenericItemData validate() {
		return (GenericItemData) new DataValidator().validate(this).result();
	}
}
