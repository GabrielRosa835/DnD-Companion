package dnd_companion.actors.entities.armor;

import dnd_companion.actors.components.measure.Price;
import dnd_companion.actors.components.measure.Weight;
import dnd_companion.actors.entities.armor.category.ArmorCategoryEntity;
import dnd_companion.actors.entities.item.item_tag.ItemTagEntity;
import dnd_companion.actors.entities.system.unit.currency.data.NormalCurrencyUnit;
import dnd_companion.actors.entities.system.unit.weight.data.NormalWeightUnit;
import dnd_companion.actors.models.EntityBuilder;

public class ArmorBuilder implements EntityBuilder
{
	private String name = "No name";
	private Price price = new Price(1, new NormalCurrencyUnit());
	private Weight weight = new Weight(1, new NormalWeightUnit());
	private ItemTagEntity[] tags = new ItemTagEntity[] {};
	private String description = "No description";
	private ArmorCategoryEntity category = null;
	private int armor_class = 10;
	private int strength_requirement = 0;
	private boolean stealth_disadvantage = false;

	ArmorBuilder() {}

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
	public ArmorBuilder weight(Weight weight) {
		this.weight = weight;
		return this;
	}
	public ArmorBuilder tags(ItemTagEntity... tags) {
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
