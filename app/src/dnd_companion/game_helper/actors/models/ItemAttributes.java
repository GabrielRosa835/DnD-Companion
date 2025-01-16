package dnd_companion.game_helper.actors.models;

import dnd_companion.game_helper.actors.components.measures.Price;
import dnd_companion.game_helper.actors.components.measures.Weight;
import dnd_companion.game_helper.actors.entities.items.ItemTagEntity;

public interface ItemAttributes
{
	public String name();
	public Price price();
	public Weight weight();
	public ItemTagEntity[] tags();	
	public String description();
}
