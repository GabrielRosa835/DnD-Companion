package dnd_companion.local_storage.structure.data.system;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.structure.data.SystemData;

public record DamageTypeData (
	String name
) implements SystemData {
	@Override public String collection() {return "damage-types";}
	@Override public String file_name() {return ToolBox.to_snake_case(this.name);}
	
	public DamageTypeData() {
		this(null);
	}
}
