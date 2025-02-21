package dnd_companion.actors.entities.item;

import dnd_companion.actors.components.measure.Price;
import dnd_companion.actors.components.measure.Weight;

public interface Item 
{
	String name();
	Price price();
	Weight weight();
	Tags[] tags();
	String description();
	
	public static enum Tags {
		ADVENTURING_GEAR, AMMUNITION, ARMOR, FOOD_AND_DRINK, INSTRUMENT, MAGICAL, TOOL, WEAPON;
	}
}
