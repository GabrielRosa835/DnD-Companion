package dnd_companion.local_storage.data_structure.json.items;

import dnd_companion.local_storage.data_structure.json.templates.Data;
import dnd_companion.local_storage.data_structure.json.templates.Item;
import dnd_companion.local_storage.system_components.ToolBox;

public record GenericItemData(
	String name,
	double price_value,
	String price_unit,
	double weight_value,
	String weight_unit,
	String[] tags,
	String description
) implements Item, Data {
	@Override
	public String collection() {return "items";}
	@Override
	public String file_name() {return ToolBox.to_snake_case(this.name);}
}
