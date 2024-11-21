package dnd_companion.game_helper.local_storage.data.structure;

import dnd_companion.game_helper.local_storage.Data;

public interface ItemData extends Data 
{
	public String name();
	public String collection();
	public double normalized_price();
	public double normalized_weight();
	public String[] tags();
	public String description();
}
