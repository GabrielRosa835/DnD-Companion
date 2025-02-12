package dnd_companion.actors.entities.item.item_tag;

import com.fasterxml.jackson.annotation.JsonProperty;

import dnd_companion.actors.models.IEntity;
import dnd_companion.effects.IEffect;

public class ItemTagEntity implements IEntity
{
	@JsonProperty private String name;
	@Override public String name() {return name;}
	
	@JsonProperty private int id;
	public int id() {return id;}

	ItemTagEntity(String name) {
		this.name = name;
		this.id = (int) Math.floor(Math.random());
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
	
	public interface InterEffect extends IEffect {
		public String changeName();
	}
}
