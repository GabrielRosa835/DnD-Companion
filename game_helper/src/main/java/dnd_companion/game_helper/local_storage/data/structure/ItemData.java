package dnd_companion.game_helper.local_storage.data.structure;

import dnd_companion.game_helper.local_storage.data.manipulation.atomic.price.Price;
import dnd_companion.game_helper.local_storage.data.manipulation.atomic.weight.Weight;
import dnd_companion.game_helper.local_storage.system_components.Data;

public interface ItemData extends Data 
{
	public String name();
	public String collection();
	public Price price();
	public Weight weight();
	public String[] tags();
	public String description();
}
