package dnd_companion.local_storage.structure.data.items;

import dnd_companion.local_storage.structure.data.Data;

public interface ItemProperties extends Data
{
	public String name();
	public double price_value();
	public String price_unit();
	public double weight_value();
	public String weight_unit();
	public String[] tags();
	public String description();
}
