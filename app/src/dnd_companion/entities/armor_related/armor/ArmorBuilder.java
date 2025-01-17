package dnd_companion.entities.armor_related.armor;

import dnd_companion.entities.DataHandler;
import dnd_companion.entities.armor_related.armor_category.ArmorCategoryCentral;
import dnd_companion.entities.armor_related.armor_category.ArmorCategoryEntity;
import dnd_companion.entities.components.Price;
import dnd_companion.entities.components.Weight;
import dnd_companion.entities.models.EntityBuilder;

public class ArmorBuilder implements EntityBuilder
{
	private String name;
	private Price price;
	private Weight weight;
	private String[] tags;
	private String description;
	private ArmorCategoryEntity category;
	private int armor_class;
	private int strength_requirement;
	private boolean stealth_disadvantage;
	
	@Override public ArmorEntity build() {
		return new ArmorEntity(
			name, 
			price, 
			weight, 
			tags, 
			description, 
			category, 
			armor_class, 
			strength_requirement, 
			stealth_disadvantage
		);
	}
	
	public ArmorBuilder name(String name) {
		this.name = name;
		return this;
	}
	
	public ArmorBuilder price(Price price) {
		this.price = price;
		return this;
	}
	public ArmorBuilder price(double price_value, String price_unit) {
		this.price = new Price(price_value, price_unit);
		return this;
	}
	
	public ArmorBuilder weight(Weight weight) {
		this.weight = weight;
		return this;
	}
	public ArmorBuilder weight(double weight_value, String weight_unit) {
		this.weight = new Weight(weight_value, weight_unit);
		return this;
	}
	
	public ArmorBuilder tags(String... tags) {
		this.tags = tags;
		return this;
	}
	
	public ArmorBuilder description(String description) {
		this.description = description;
		return this;
	}
	
	public ArmorBuilder category(ArmorCategoryEntity category) {
		this.category = category;
		return this;
	}
	public ArmorBuilder category(String category_name) {
		this.category = (ArmorCategoryEntity) new DataHandler()
				.retrieve(new ArmorCategoryCentral(), category_name)
				.get();
		return this;
	}
	
	public ArmorBuilder armor_class(int armor_class) {
		this.armor_class = armor_class;
		return this;
	}
	public ArmorBuilder strength_requirement(int strength_requirement) {
		this.strength_requirement = strength_requirement;
		return this;
	}
	public ArmorBuilder stealth_disadvantage(boolean stealth_disadvantage) {
		this.stealth_disadvantage = stealth_disadvantage;
		return this;
	}
}
