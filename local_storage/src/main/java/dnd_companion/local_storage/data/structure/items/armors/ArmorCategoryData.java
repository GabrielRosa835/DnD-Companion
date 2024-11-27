package dnd_companion.local_storage.data.structure.items.armors;

import dnd_companion.local_storage.data.structure.templates.OptionData;
import dnd_companion.local_storage.system_components.utils.ToolBox;

public record ArmorCategoryData (String... options)
implements OptionData<String> 
{
	public ArmorCategoryData {
		options = ToolBox.to_snake_case(options);
	}
	
	public String collection() {return "armors";}
	public String name() {return "armor-categories";}
}
