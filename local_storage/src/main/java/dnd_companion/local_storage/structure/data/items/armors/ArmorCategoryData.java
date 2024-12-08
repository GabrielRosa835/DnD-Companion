package dnd_companion.local_storage.structure.data.items.armors;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.structure.data.Data;

public record ArmorCategoryData (
	String name
) implements Data {
	@Override public String collection() {return "armor-categories";}
	@Override public String file_name() {return ToolBox.to_snake_case(this.name);}
	
	public ArmorCategoryData() {
		this(null);
	}
}
