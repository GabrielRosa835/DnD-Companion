package dnd_companion.local_storage.structure.items.armors;

import dnd_companion.common.metadata.CollectionREF;
import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;
import dnd_companion.local_storage.structure.models.ItemData;

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
) implements ItemData {
	private static CollectionsMetadata collections = new CollectionsMetadata();
	private static ToolBox tools = new ToolBox();
	
	@Override public CollectionREF collection() {return collections.armors();}
	@Override public String file_name() {return tools.to_snake_case(this.name) + ".json";}
}
