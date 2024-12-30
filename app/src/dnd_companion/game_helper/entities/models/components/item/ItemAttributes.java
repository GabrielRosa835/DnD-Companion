package dnd_companion.game_helper.entities.models.components.item;

import dnd_companion.game_helper.entities.components.items.tags.ItemTagComponent;
import dnd_companion.game_helper.entities.elements.system.units.Price;
import dnd_companion.game_helper.entities.elements.system.units.Weight;

public interface ItemAttributes
{
	public String name();
	public Price price();
	public Weight weight();
	public ItemTagComponent[] tags();	
	public String description();
}
