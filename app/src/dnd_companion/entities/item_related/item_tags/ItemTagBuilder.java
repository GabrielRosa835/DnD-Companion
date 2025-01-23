package dnd_companion.entities.item_related.item_tags;

import dnd_companion.entities.addons.models.EntityBuilder;

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
