package dnd_companion.local_storage.structure.data.items.ammunition;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.structure.data.items.ItemData;
import dnd_companion.local_storage.structure.data.items.ItemProperties;

public record AmmoData(
	String name,
	double price_value,
	String price_unit,
	double weight_value,
	String weight_unit,
	String[] tags,
	String description
) implements ItemProperties, ItemData {
	@Override public String collection() {return "ammunitions";}
	@Override public String file_name() {return ToolBox.to_snake_case(this.name);}
	
	public AmmoData() {
		this(null, 0, null, 0, null, null, null);
	}
}
