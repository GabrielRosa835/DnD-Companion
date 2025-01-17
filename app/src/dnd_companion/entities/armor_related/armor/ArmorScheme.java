package dnd_companion.entities.armor_related.armor;

import dnd_companion.entities.models.Entity;
import dnd_companion.entities.models.EntityScheme;

public class ArmorScheme implements EntityScheme
{
	private String name;
	private double price_value;
	private String price_unit;
	private double weight_value;
	private String weight_unit;
	private String[] tags;
	private String description;
	private String category;
	private int armor_class;
	private int strength_requirement;
	private boolean stealth_disadvantage;
	
	@Override public ArmorScheme loadEntity(Entity entity) {
		ArmorEntity cast_entity = (ArmorEntity) entity;
		this.name = cast_entity.name();
		this.price_value = cast_entity.price().value();
		this.price_unit = cast_entity.price().unit();
		this.weight_value = cast_entity.weight().value();
		this.weight_unit = cast_entity.weight().unit();
		this.tags = cast_entity.tags();
		this.description = cast_entity.description();
		this.category = cast_entity.category().name();
		this.armor_class = cast_entity.armor_class();
		this.strength_requirement = cast_entity.strength_requirement();
		this.stealth_disadvantage = cast_entity.stealth_disadvantage();
		return this;
	}
	
	@Override public ArmorEntity retrieveEntity() {
		return new ArmorBuilder()
				.name(name)
				.price(price_value, price_unit)
				.weight(weight_value, weight_unit)
				.tags(tags)
				.description(description)
				.category(category)
				.armor_class(armor_class)
				.strength_requirement(strength_requirement)
				.stealth_disadvantage(stealth_disadvantage)
				.build();
	}
	
}
