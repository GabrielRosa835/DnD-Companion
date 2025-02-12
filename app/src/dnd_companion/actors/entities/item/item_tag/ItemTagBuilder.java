package dnd_companion.actors.entities.item.item_tag;

import dnd_companion.actors.models.IEntityBuilder;

public class ItemTagBuilder implements IEntityBuilder
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
