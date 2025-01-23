package dnd_companion.entities.item_related.item_tags;

import dnd_companion.entities.addons.models.Entity;

public class ItemTagEntity implements Entity 
{
	String name;
	@Override public String name() {return name;}
	
	ItemTagEntity(String name) {
		this.name = name;
	}
	protected ItemTagEntity(ItemTagEntity entity) {
		this(entity.name);
	}
	
	@Override public ItemTagEntity clone() {
		return new ItemTagEntity(this);
	}
	@Override public String toString() {
		return String.format("ItemTag[name=%s]", name);
	}
}
