package dnd_companion.actors.models.types;

import dnd_companion.actors.components.measure.Price;
import dnd_companion.actors.components.measure.Weight;
import dnd_companion.actors.entities.item.item_tag.ItemTagEntity;

public interface Item
{
	public String name();
	public Price price();
	public Weight weight();
	public ItemTagEntity[] tags();
	public String description();
}
