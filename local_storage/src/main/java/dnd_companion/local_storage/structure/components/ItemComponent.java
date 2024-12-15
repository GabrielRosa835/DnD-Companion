package dnd_companion.local_storage.structure.components;

import dnd_companion.local_storage.structure.components.items.tags.ItemTagComponent;
import dnd_companion.local_storage.structure.components.system.units.PriceComponent;
import dnd_companion.local_storage.structure.components.system.units.WeightComponent;

public interface ItemComponent 
{
	public String name();
	public PriceComponent price();
	public WeightComponent weight();
	public ItemTagComponent[] tags();	
	public String description();
}
