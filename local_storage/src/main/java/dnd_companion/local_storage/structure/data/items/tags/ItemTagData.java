package dnd_companion.local_storage.structure.data.items.tags;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.structure.data.Data;

public record ItemTagData (String name)
implements Data
{
	@Override public String collection() {return "tags";}
	@Override public String file_name() {return ToolBox.to_snake_case(this.name);}
	
	public ItemTagData() {
		this(null);
	}
}
