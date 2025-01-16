package dnd_companion.game_helper.actors.entities.items;

import dnd_companion.app.local_storage.handling.DataHandler;
import dnd_companion.app.local_storage.tools.DataKey;
import dnd_companion.game_helper.actors.data.items.tags.ItemTagData;

public class ItemTagEntity
{
	private String name;
	public String name() {return this.name;}

	public ItemTagEntity(String name) {
		ItemTagData data = (ItemTagData) new DataHandler()
				.retrieve(new DataKey(new ItemTagData().collection(), name, ItemTagData.class))
				.result();
		this.name = data.name();
	}
}
