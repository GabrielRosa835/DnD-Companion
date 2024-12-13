package dnd_companion.local_storage.structure.data.items.tags;

import dnd_companion.local_storage.common.ToolBox;
import dnd_companion.local_storage.structure.data.ItemData;
import dnd_companion.local_storage.validation.DataValidator;

public record ItemTagData (
	String name
) implements ItemData {
	@Override public String collection() {return "tags";}
	@Override public String file_name() {return ToolBox.to_snake_case(this.name);}
	
	public ItemTagData() {
		this(null);
	}
	public ItemTagData validate() {
		return (ItemTagData) new DataValidator().validate(this).result();
	}
}
