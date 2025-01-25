package dnd_companion.entities.rule_related.action_types;

import javax.xml.crypto.Data;

import dnd_companion.common.metadata.CollectionREF;
import dnd_companion.common.metadata.CollectionsMetadata;
import dnd_companion.common.tools.ToolBox;

public record ActionTypeData (
	String name
) implements Data {
	private static CollectionsMetadata collections = new CollectionsMetadata();
	private static ToolBox tools = new ToolBox();

	@Override public CollectionREF collection() {return collections.action_types();}
	@Override public String file_name() {return ToolBox.toFileName(this.name);}
}
