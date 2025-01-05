package dnd_companion.game_helper.entities.models;

import dnd_companion.game_helper.entities.components.items.tags.ItemTagComponent;
import dnd_companion.game_helper.entities.measures.Price;
import dnd_companion.game_helper.entities.measures.Weight;

public interface ItemAttributes
{
	public String name();
	public Price price();
	public Weight weight();
	public ItemTagComponent[] tags();	
	public String description();
}
