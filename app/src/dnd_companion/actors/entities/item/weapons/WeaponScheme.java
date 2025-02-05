package dnd_companion.actors.entities.item.weapons;

import java.util.Arrays;

import dnd_companion.actors.components.measure.Price;
import dnd_companion.actors.components.measure.Weight;
import dnd_companion.actors.models.Entity;
import dnd_companion.actors.models.EntityScheme;
import dnd_companion.entities.item.weapons.type.WeaponTypeEntity;
import dnd_companion.entities.system.unit.currency.CurrencyUnitCentral;
import dnd_companion.entities.system.unit.weight.WeightUnitCentral;

public class WeaponScheme implements EntityScheme
{
	private String name;
	private double priceValue;
	private String priceUnit;
	private double weightValue;
	private String weightUnit;
	private String[] tags;
	private String description;
	private String category;
	private String type;
	private int    damageDiceAmount;
	private String damageDiceType;
	private String damageType;
	private String[] properties;
	private String mastery;
	private double minRangeValue;
	private String minRangeUnit;
	private double maxRangeValue;
	private String maxRangeUnit;
	private String versatileDiceType;
	
	@Override public WeaponScheme loadEntity(Entity entity) {
		WeaponEntity e = (WeaponEntity) entity;
		this.name = e.name();
		this.priceValue = e.price().value();
		this.priceUnit = e.price().unit().name();
		this.weightValue = e.weight().value();
		this.weightUnit = e.weight().unit().name();
		this.tags = Arrays.stream(e.tags()).map(t -> t.name()).toArray(String[]::new);
		this.description = e.description();
		this.type = e.type().name();
		this.damageDiceAmount = e.damage().diceAmmount();
		this.damageDiceType = e.damage().dice().name();
		this.damageType = e.damage().type().name();
		this.properties = Arrays.stream(e.properties()).map(p -> p.name()).toArray(String[]::new);
		this.mastery = e.mastery().name();
		this.minRangeValue = e.range().minRange().value();
		this.minRangeUnit = e.range().minRange().unit().name();
		this.maxRangeValue = e.range().maxRange().value();
		this.maxRangeUnit = e.range().maxRange().unit().name();
		this.versatileDiceType = e.damage().versatileDice().name();
		return this;
	}

	@Override public WeaponEntity retrieveEntity() {
		Price price = new Price(priceValue, new CurrencyUnitCentral().retrieve(priceUnit));
		Weight weight = new Weight(weightValue, WeightUnitCentral.use().retrieve(weightUnit));
		WeaponTypeEntity type = WeaponTypeCentral.use().retrieve(type);
		
		return new WeaponCentral().builder()
				.name(name)
				.price(price)
				.weight(weight)
				.tags(Arrays.stream(tags).map(t -> ItemTagCentral.use().retrieve(t)))
				.description(description)
				.type(type)
	}

}
