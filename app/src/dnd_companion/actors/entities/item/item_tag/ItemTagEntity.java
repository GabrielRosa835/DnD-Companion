package dnd_companion.actors.entities.item.item_tag;

import dnd_companion.actors.models.Entity;
import dnd_companion.effects.Effect;

public class ItemTagEntity implements Entity
{
	private String name;
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
	
	public interface InterEffect extends Effect {
		public String changeName();
	}
}
