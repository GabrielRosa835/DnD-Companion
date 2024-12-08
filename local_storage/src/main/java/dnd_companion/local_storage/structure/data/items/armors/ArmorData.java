package dnd_companion.local_storage.structure.data.items.armors;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.structure.data.Data;
import dnd_companion.local_storage.structure.data.items.ItemProperties;

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
) implements ItemProperties, Data {
	@Override public String collection() {return "armors";}
	@Override public String file_name() {return ToolBox.to_snake_case(this.name);}
	
	public ArmorData() {
		this(null, 0, null, 0, null, null, null, null, 0, 0, false);
	}
}
