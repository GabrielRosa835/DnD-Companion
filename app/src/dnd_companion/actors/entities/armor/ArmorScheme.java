package dnd_companion.actors.entities.armor;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

import dnd_companion.actors.components.measure.Price;
import dnd_companion.actors.components.measure.Weight;
import dnd_companion.actors.entities.armor.category.ArmorCategoryCentral;
import dnd_companion.actors.entities.armor.category.ArmorCategoryEntity;
import dnd_companion.actors.entities.item.item_tag.ItemTagCentral;
import dnd_companion.actors.entities.item.item_tag.ItemTagEntity;
import dnd_companion.actors.entities.system.unit.currency.CurrencyUnitCentral;
import dnd_companion.actors.entities.system.unit.weight.WeightUnitCentral;
import dnd_companion.actors.models.Entity;
import dnd_companion.actors.models.EntityScheme;

public class ArmorScheme implements EntityScheme
{
	@JsonProperty private String name;
	@JsonProperty private double priceValue;
	@JsonProperty private String priceUnit;
	@JsonProperty private double weightValue;
	@JsonProperty private String weightUnit;
	@JsonProperty private String[] tags;
	@JsonProperty private String description;
	@JsonProperty private String category;
	@JsonProperty private int armorClass;
	@JsonProperty private int strengthRequirement;
	@JsonProperty private boolean stealthDisadvantage;

	ArmorScheme() {}

	@Override public ArmorScheme loadEntity(Entity e) {
		ArmorEntity entity = (ArmorEntity) e;
		this.name = entity.name();
		this.priceValue = entity.price().value();
		this.priceUnit = entity.price().unit().name();
		this.weightValue = entity.weight().value();
		this.weightUnit = entity.weight().unit().name();
		this.tags = Arrays.stream(entity.tags())
				.map(t -> t.name())
				.toArray(String[]::new);
		this.description = entity.description();
		this.category = entity.category().name();
		this.armorClass = entity.armorClass();
		this.strengthRequirement = entity.strengthRequirement();
		this.stealthDisadvantage = entity.stealthDisadvantage();
		return this;
	}

	@Override public ArmorEntity retrieveEntity() {
		Price price = new Price(priceValue, CurrencyUnitCentral.use().retrieve(priceUnit));
		Weight weight = new Weight(weightValue, WeightUnitCentral.use().retrieve(weightUnit));
		ItemTagEntity[] tags = Arrays.stream(this.tags)
				.map(t -> ItemTagCentral.use().retrieve(t))
				.toArray(ItemTagEntity[]::new);
		ArmorCategoryEntity category = ArmorCategoryCentral.use().retrieve(this.category);
		return new ArmorBuilder()
				.name(name)
				.price(price)
				.weight(weight)
				.tags(tags)
				.description(description)
				.category(category)
				.armor_class(armorClass)
				.strength_requirement(strengthRequirement)
				.stealth_disadvantage(stealthDisadvantage)
				.build();
	}

}
