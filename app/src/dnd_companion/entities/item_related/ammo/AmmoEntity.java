package dnd_companion.entities.item_related.ammo;

import java.util.Arrays;

import dnd_companion.entities.addons.components.measure.Price;
import dnd_companion.entities.addons.components.measure.Weight;
import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.types.Item;
import dnd_companion.entities.item_related.item_tag.ItemTagEntity;

public class AmmoEntity implements Entity, Item
{
	private String name;
	@Override public String name() {return this.name;}

	private Price price;
	@Override public Price price() {return this.price;}

	private Weight weight;
	@Override public Weight weight() {return this.weight;}

	private ItemTagEntity[] tags;
	@Override public ItemTagEntity[] tags() {return this.tags;}

	private String description;
	@Override public String description() {return this.description;}

	AmmoEntity (String name, Price price, Weight weight, ItemTagEntity[] tags, String description) {
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.tags = tags;
		this.description = description;
	}
	private AmmoEntity(AmmoEntity entity) {
		this(
				entity.name, 
				entity.price.clone(), entity.weight.clone(), 
				Arrays.stream(entity.tags)
						.map(i -> i.clone())
						.toArray(ItemTagEntity[]::new), 
				entity.description);
	}
	
	@Override public String toString() {
		return String.format("Ammunition[name=%s, price=%s, weight=%s, tags=%s, description=%s", 
				name, price.toString(), weight.toString(), Arrays.toString(tags), description);
	}
	@Override public AmmoEntity clone() {
		return new AmmoEntity(this);
	}
}
