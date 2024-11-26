package dnd_companion.local_storage.data.structure.templates;

import dnd_companion.local_storage.data.manipulation.value_group.Price;
import dnd_companion.local_storage.data.manipulation.value_group.Weight;

public interface ItemData extends Data 
{
	public Price price();
	public Weight weight();
	public String[] tags();
	public String description();
}
