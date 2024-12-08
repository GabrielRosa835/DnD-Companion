package dnd_companion.local_storage.structure.data.system;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.structure.data.Data;

public record ActionTypeData (
	String name
) implements Data {
	@Override public String collection() {return "action-types";}
	@Override public String file_name() {return ToolBox.to_snake_case(this.name);}
	
	public ActionTypeData() {
		this(null);
	}
}
