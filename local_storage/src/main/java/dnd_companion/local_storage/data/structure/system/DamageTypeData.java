package dnd_companion.local_storage.data.structure.system;

import dnd_companion.local_storage.data.structure.templates.OptionData;
import dnd_companion.local_storage.system_components.utils.ToolBox;

public record DamageTypeData (String... options)
implements OptionData<String> 
{
	public DamageTypeData {
		options = ToolBox.to_snake_case(options);
	}
	
	public String collection() {return "system";}
	public String name() {return "damage-types";}
}
