package dnd_companion.entities.addons.models.types;

import dnd_companion.entities.addons.components.measure.Price;
import dnd_companion.entities.addons.components.measure.Weight;
import dnd_companion.entities.item_related.item_tag.ItemTagEntity;

public interface Item
{
	public String name();
	public Price price();
	public Weight weight();
	public ItemTagEntity[] tags();
	public String description();
}
