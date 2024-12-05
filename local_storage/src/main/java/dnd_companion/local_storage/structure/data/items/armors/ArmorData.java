package dnd_companion.local_storage.structure.data.items.armors;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.structure.data.templates.Data;
import dnd_companion.local_storage.structure.data.templates.Item;

public record ArmorData(
	String name,
	double price_value,
	String price_unit,
	double weight_value,
	String weight_unit,
	String[] tags,
	String description,
	String category,
	int armor_class,
	int strength_requirement,
	boolean stealth_disadvantage
) implements Item, Data {
	@Override
	public String collection() {return "armors";}
	@Override
	public String file_name() {return ToolBox.to_snake_case(this.name);}
}
