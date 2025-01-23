package dnd_companion.entities.addons.models.types;

import dnd_companion.entities.addons.components.Price;
import dnd_companion.entities.addons.components.Weight;

public interface Item
{
	public String name();
	public Price price();
	public Weight weight();
	public String[] tags();	
	public String description();
}
