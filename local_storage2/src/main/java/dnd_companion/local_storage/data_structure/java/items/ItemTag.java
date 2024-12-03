package dnd_companion.local_storage.data_structure.java.items;

import dnd_companion.local_storage.data_structure.json.items.ItemTagData;
import dnd_companion.local_storage.data_validation.DataValidator;
import dnd_companion.local_storage.system_components.DataKey;

public class ItemTag
{
	private String name;
	public String name() {return this.name;}

	public ItemTag(String name) {
		this.name = DataValidator.validate_option(new DataKey(ItemTagData.class), name);
	}
}
