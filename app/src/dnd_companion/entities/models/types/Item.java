package dnd_companion.entities.models.types;

import dnd_companion.entities.components.Price;
import dnd_companion.entities.components.Weight;

public interface Item
{
	public String name();
	public Price price();
	public Weight weight();
	public String[] tags();	
	public String description();
}
