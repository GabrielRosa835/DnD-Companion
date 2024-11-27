package dnd_companion.local_storage.data.structure.items;

import dnd_companion.local_storage.data.structure.templates.OptionData;
import dnd_companion.local_storage.system_components.utils.ToolBox;

public record ItemTagData (String... options)
implements OptionData<String> 
{
	public ItemTagData {
		options = ToolBox.to_snake_case(options);
	}
	
	public String collection() {return "items";}
	public String name() {return "item-tags";}
}
