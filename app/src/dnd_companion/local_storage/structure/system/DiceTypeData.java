package dnd_companion.local_storage.structure.system;

import dnd_companion.common.ToolBox;
import dnd_companion.common.metadata.CollectionREF;
import dnd_companion.common.metadata.Collections;
import dnd_companion.local_storage.structure.models.Data;

public record DiceTypeData (
	int max_value
) implements Data {
	@Override public CollectionREF collection() {return Collections.dice_types;}
	@Override public String file_name() {return ToolBox.to_snake_case(this.name()) + ".json";}
	
	public String name() {return String.format("D%d", this.max_value);}
}
