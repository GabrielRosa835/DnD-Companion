package dnd_companion.local_storage.structure.items;

import dnd_companion.common.ToolBox;
import dnd_companion.common.metadata.CollectionREF;
import dnd_companion.common.metadata.Collections;
import dnd_companion.local_storage.structure.models.ItemData;

public record AmmoData(
	String name,
	double price_value,
	String price_unit,
	double weight_value,
	String weight_unit,
	String[] tags,
	String description
) implements ItemData {
	@Override public CollectionREF collection() {return Collections.ammunitions;}
	@Override public String file_name() {return ToolBox.to_snake_case(this.name) + ".json";}
}
