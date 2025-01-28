package dnd_companion.entities.armor_related.armor;

import dnd_companion.entities.addons.components.measure.Price;
import dnd_companion.entities.addons.components.measure.Weight;
import dnd_companion.entities.addons.models.EntityBuilder;
import dnd_companion.entities.armor_related.armor_category.ArmorCategoryEntity;
import dnd_companion.entities.armor_related.armor_category.data.DefaultArmorCategory;
import dnd_companion.entities.item_related.item_tag.ItemTagEntity;
import dnd_companion.entities.unit_related.currency.CurrencyUnitEntity;
import dnd_companion.entities.unit_related.currency.data.DefaultCurrencyUnit;
import dnd_companion.entities.unit_related.weight.WeightUnitEntity;
import dnd_companion.entities.unit_related.weight.data.DefaultWeightUnit;

public class ArmorBuilder implements EntityBuilder
{
	private String name = "No name";
	private Price price = new Price(0, new DefaultCurrencyUnit());
	private Weight weight = new Weight(0, new DefaultWeightUnit());
	private ItemTagEntity[] tags = new ItemTagEntity[] {};
	private String description = "No description";
	private ArmorCategoryEntity category = new DefaultArmorCategory();
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
	public ArmorBuilder price(double price_value, CurrencyUnitEntity price_unit) {
		this.price = new Price(price_value, price_unit);
		return this;
	}

	public ArmorBuilder weight(Weight weight) {
		this.weight = weight;
		return this;
	}
	public ArmorBuilder weight(double weight_value, WeightUnitEntity weight_unit) {
		this.weight = new Weight(weight_value, weight_unit);
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
