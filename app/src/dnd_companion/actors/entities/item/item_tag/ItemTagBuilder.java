package dnd_companion.actors.entities.item.item_tag;

import dnd_companion.actors.models.EntityBuilder;

public class ItemTagBuilder implements EntityBuilder
{
	private String name;

	ItemTagBuilder() {}

	@Override public ItemTagEntity build() {
		return new ItemTagEntity(name);
	}

	public ItemTagBuilder name(String name) {
		this.name = name;
		return this;
	}
}
