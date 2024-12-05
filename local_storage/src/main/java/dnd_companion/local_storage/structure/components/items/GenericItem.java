package dnd_companion.local_storage.structure.components.items;

import dnd_companion.local_storage.structure.components.system.units.Price;
import dnd_companion.local_storage.structure.components.system.units.Weight;

public class GenericItem
{
	private String name;
	private Price price;
	private Weight weight;
	private ItemTag[] tags;	
	private String description;
	
	public String name() {return this.name;}
	public Price price() {return this.price;}
	public Weight weight() {return this.weight;}
	public ItemTag[] tags() {return this.tags;}
	public String description() {return this.description;}
	
	public GenericItem(
		String name, 
		Price price, 
		Weight weight, 
		ItemTag[] tags, 
		String description
	) {
		super();
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.tags = tags;
		this.description = description;
	}
	
	
}
