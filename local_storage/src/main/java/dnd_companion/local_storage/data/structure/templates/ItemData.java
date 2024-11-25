package dnd_companion.local_storage.data.structure.templates;

import dnd_companion.local_storage.data.manipulation.ItemTags;
import dnd_companion.local_storage.data.manipulation.price.Price;
import dnd_companion.local_storage.data.manipulation.weight.Weight;

public interface ItemData extends Data 
{
	public Price price();
	public Weight weight();
	public ItemTags tags();
	public String description();
}
