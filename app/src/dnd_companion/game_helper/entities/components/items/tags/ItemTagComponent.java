package dnd_companion.game_helper.entities.components.items.tags;

import dnd_companion.app.local_storage.handling.DataHandler;
import dnd_companion.app.local_storage.tools.DataKey;
import dnd_companion.game_helper.entities.data.items.tags.ItemTagData;

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
