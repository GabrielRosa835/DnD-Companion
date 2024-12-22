package dnd_companion.local_storage.models.components.item;

import dnd_companion.local_storage.structure.components.items.tags.ItemTagComponent;
import dnd_companion.local_storage.structure.elements.system.units.Price;
import dnd_companion.local_storage.structure.elements.system.units.Weight;

public interface ItemAttributes
{
	public String name();
	public Price price();
	public Weight weight();
	public ItemTagComponent[] tags();	
	public String description();
}
