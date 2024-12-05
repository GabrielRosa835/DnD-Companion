package dnd_companion.local_storage.structure.components.items;

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.structure.data.items.ItemTagData;
import dnd_companion.local_storage.validation.DataValidator;

public class ItemTag
{
	private String name;
	public String name() {return this.name;}

	public ItemTag(String name) {
		this.name = DataValidator.validate_option(new DataKey(ItemTagData.class), name);
	}
}
