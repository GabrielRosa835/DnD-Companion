package dnd_companion.actors.entities.system;

import javax.xml.crypto.Data;

import dnd_companion.common.ToolBox;
import dnd_companion.common.metadata.CollectionREF;
import dnd_companion.common.metadata.CollectionsMetadata;

public record DiceTypeData (
	int max_value
) implements Data {
	private static CollectionsMetadata collections = new CollectionsMetadata();
	private static ToolBox tools = new ToolBox();

	@Override public CollectionREF collection() {return collections.dice_types();}
	@Override public String file_name() {return ToolBox.toFileName(this.name());}

	public String name() {return String.format("D%d", this.max_value);}
}
