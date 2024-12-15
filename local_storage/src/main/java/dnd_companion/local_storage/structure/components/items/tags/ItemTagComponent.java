package dnd_companion.local_storage.structure.components.items.tags;

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.handling.DataHandler;
import dnd_companion.local_storage.structure.data.items.tags.ItemTagData;

public class ItemTagComponent
{
	private String name;
	public String name() {return this.name;}

	public ItemTagComponent(String name) {
		ItemTagData data = (ItemTagData) new DataHandler()
				.retrieve(new DataKey(new ItemTagData().collection(), name, ItemTagData.class))
				.result();
		this.name = data.name();
	}
}
