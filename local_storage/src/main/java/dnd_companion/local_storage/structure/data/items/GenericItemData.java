package dnd_companion.local_storage.structure.data.items;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.models.data.ItemData;
import dnd_companion.local_storage.validation.DataValidator;

public record GenericItemData(
	String name,
	double price_value,
	String price_unit,
	double weight_value,
	String weight_unit,
	String[] tags,
	String description
) implements ItemData {
	@Override public String collection() {return "items";}
	@Override public String file_name() {return ToolBox.to_snake_case(this.name);}
	
	public GenericItemData() {
		this(null, 0, null, 0, null, null, null);
	}
	public GenericItemData validate() {
		return (GenericItemData) new DataValidator().validate(this).result();
	}
}
