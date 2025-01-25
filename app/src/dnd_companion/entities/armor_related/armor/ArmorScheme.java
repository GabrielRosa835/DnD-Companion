package dnd_companion.entities.armor_related.armor;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.EntityScheme;
import dnd_companion.entities.armor_related.armor_category.ArmorCategoryCentral;
import dnd_companion.entities.armor_related.armor_category.ArmorCategoryEntity;
import dnd_companion.entities.item_related.item_tag.ItemTagCentral;
import dnd_companion.entities.item_related.item_tag.ItemTagEntity;
import dnd_companion.entities.unit_related.currency.CurrencyUnitCentral;
import dnd_companion.entities.unit_related.currency.CurrencyUnitEntity;
import dnd_companion.entities.unit_related.weight.WeightUnitCentral;
import dnd_companion.entities.unit_related.weight.WeightUnitEntity;

public class ArmorScheme implements EntityScheme
{
	@JsonProperty private String name;
	@JsonProperty private double price_value;
	@JsonProperty private String price_unit;
	@JsonProperty private double weight_value;
	@JsonProperty private String weight_unit;
	@JsonProperty private String[] tags;
	@JsonProperty private String description;
	@JsonProperty private String category;
	@JsonProperty private int armor_class;
	@JsonProperty private int strength_requirement;
	@JsonProperty private boolean stealth_disadvantage;

	ArmorScheme() {}

	@Override public ArmorScheme loadEntity(Entity entity) {
		ArmorEntity cast_entity = (ArmorEntity) entity;
		this.name = cast_entity.name();
		this.price_value = cast_entity.price().value();
		this.price_unit = cast_entity.price().unit().name();
		this.weight_value = cast_entity.weight().value();
		this.weight_unit = cast_entity.weight().unit().name();
		this.tags = Arrays.stream(cast_entity.tags())
				.map(t -> t.name())
				.toArray(String[]::new);
		this.description = cast_entity.description();
		this.category = cast_entity.category().name();
		this.armor_class = cast_entity.armor_class();
		this.strength_requirement = cast_entity.strength_requirement();
		this.stealth_disadvantage = cast_entity.stealth_disadvantage();
		return this;
	}

	@Override public ArmorEntity retrieveEntity() {
		CurrencyUnitEntity price_unit_entity = new CurrencyUnitCentral().retrieve(price_unit);
		WeightUnitEntity weight_unit_entity = new WeightUnitCentral().retrieve(weight_unit);
		ItemTagEntity[] tags_entities = Arrays.stream(tags)
				.map(t -> new ItemTagCentral().retrieve(t))
				.toArray(ItemTagEntity[]::new);
		ArmorCategoryEntity category_entity = new ArmorCategoryCentral().retrieve(category);
		return new ArmorBuilder()
				.name(name)
				.price(price_value, price_unit_entity)
				.weight(weight_value, weight_unit_entity)
				.tags(tags_entities)
				.description(description)
				.category(category_entity)
				.armor_class(armor_class)
				.strength_requirement(strength_requirement)
				.stealth_disadvantage(stealth_disadvantage)
				.build();
	}

}
