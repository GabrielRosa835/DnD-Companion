package dnd_companion.actors.entities.item.weapons;

import dnd_companion.actors.components.measure.Length;
import dnd_companion.actors.components.measure.Price;
import dnd_companion.actors.components.measure.Weight;
import dnd_companion.actors.components.weapon.WeaponDamage;
import dnd_companion.actors.components.weapon.WeaponRange;
import dnd_companion.actors.entities.item.item_tag.ItemTagEntity;
import dnd_companion.actors.entities.item.weapons.category.WeaponCategoryEntity;
import dnd_companion.actors.entities.item.weapons.mastery.WeaponMasteryEntity;
import dnd_companion.actors.entities.item.weapons.properties.WeaponPropertyEntity;
import dnd_companion.actors.entities.item.weapons.type.WeaponTypeEntity;
import dnd_companion.actors.entities.system.unit.currency.data.NormalCurrencyUnit;
import dnd_companion.actors.entities.system.unit.length.LengthUnitEntity;
import dnd_companion.actors.entities.system.unit.weight.data.NormalWeightUnit;
import dnd_companion.actors.models.EntityBuilder;

public class WeaponBuilder implements EntityBuilder
{
	private String name = "No name";
	private Price price = new Price(1, new NormalCurrencyUnit());
	private Weight weight = new Weight(1, new NormalWeightUnit());
	private ItemTagEntity[] tags = new ItemTagEntity[] {};
	private String description = "No description";
	private WeaponTypeEntity type;
	private WeaponCategoryEntity category;
	private WeaponMasteryEntity mastery;
	private WeaponPropertyEntity[] properties = new WeaponPropertyEntity[] {};
	private WeaponDamage damage;
	private WeaponRange range;
	
	WeaponBuilder() {}
	
	@Override public WeaponEntity build() {
		return new WeaponEntity(name, price, weight, tags, description, type, 
				category, mastery, properties, damage, range);
	}

	public WeaponBuilder name(String name) {
		this.name = name;
		return this;
	}
	public WeaponBuilder price(Price price) {
		this.price = price;
		return this;
	}
	public WeaponBuilder weight(Weight weight) {
		this.weight = weight;
		return this;
	}	
	public WeaponBuilder tags(ItemTagEntity... tags) {
		this.tags = tags;
		return this;
	}
	public WeaponBuilder description(String description) {
		this.description = description;
		return this;
	}
	public WeaponBuilder type(WeaponTypeEntity type) {
		this.type = type;
		return this;
	}
	public WeaponBuilder category(WeaponCategoryEntity category) {
		this.category = category;
		return this;
	}
	public WeaponBuilder mastery(WeaponMasteryEntity mastery) {
		this.mastery = mastery;
		return this;
	}
	public WeaponBuilder properties(WeaponPropertyEntity... properties) {
		this.properties = properties;
		return this;
	}
	public WeaponBuilder damage(WeaponDamage damage) {
		this.damage = damage;
		return this;
	}
	public WeaponBuilder range(WeaponRange range) {
		this.range = range;
		return this;
	}
	public WeaponBuilder range(double minValue, double maxValue, LengthUnitEntity unit) {
		this.range = new WeaponRange(new Length(minValue, unit), new Length(maxValue, unit));
		return this;
	}
}
