package dnd_companion.entities.armor_related.armor;

import java.util.Arrays;

import dnd_companion.entities.addons.components.Price;
import dnd_companion.entities.addons.components.Weight;
import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.armor_related.armor_category.ArmorCategoryEntity;
import dnd_companion.entities.item_related.item_tags.ItemTagEntity;

public class ArmorEntity implements Entity
{
	private String name;
	private Price price;
	private Weight weight;
	private ItemTagEntity[] tags;
	private String description;
	private ArmorCategoryEntity category;
	private int armor_class;
	private int strength_requirement;
	private boolean stealth_disadvantage;
	
	@Override public String name() {return name;}
	public Price price() {return price;}
	public Weight weight() {return weight;}
	public ItemTagEntity[] tags() {return tags;}
	public String description() {return description;}
	public ArmorCategoryEntity category() {return this.category;}
	public int armor_class() {return this.armor_class;}
	public int strength_requirement() {return this.strength_requirement;}
	public boolean stealth_disadvantage() {return this.stealth_disadvantage;}
	
	ArmorEntity(
		String name, 
		Price price, 
		Weight weight, 
		ItemTagEntity[] tags, 
		String description,
		ArmorCategoryEntity category,
		int armor_class,
		int strength_requirement,
		boolean stealth_disadvantage
	) {
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.tags = tags;
		this.description = description;
		this.category = category;
		this.armor_class = armor_class;
		this.strength_requirement = strength_requirement;
		this.stealth_disadvantage = stealth_disadvantage;
	}
	protected ArmorEntity(ArmorEntity entity) {
		this(
			entity.name, 
			entity.price.clone(), 
			entity.weight.clone(), 
			Arrays.stream(entity.tags)
				.map(t -> t.clone())
				.toArray(ItemTagEntity[]::new), 
			entity.description,
			entity.category.clone(),
			entity.armor_class,
			entity.strength_requirement,
			entity.stealth_disadvantage
		);
	}
	
	@Override public ArmorEntity clone() {
		return new ArmorEntity(this);
	}
	@Override public String toString() {
		return String.format("Armor[name=%s, price=%s, weight=%s, tags=%s, description=%s]",
				name, price.toString(), weight.toString(), Arrays.toString(tags), description);
	}
}
