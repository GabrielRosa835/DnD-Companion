package dnd_companion.entities.unit_related.weight;

import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.types.Unit;

public class WeightUnitEntity implements Entity, Unit
{
	String name;
	String plural;
	String abbreviation;
	double normalizing_factor;
	
	@Override public String name() {return name;}
	@Override public String plural() {return plural;}
	@Override public String abbreviation() {return abbreviation;}
	@Override public double normalizing_factor() {return normalizing_factor;}
	
	WeightUnitEntity(String name, String plural, String abbreviation, double normalizing_factor) {
		this.name = name;
		this.plural = plural;
		this.abbreviation = abbreviation;
		this.normalizing_factor = normalizing_factor;
	}
	protected WeightUnitEntity(WeightUnitEntity entity) {
		this(entity.name, entity.plural, entity.abbreviation, entity.normalizing_factor);
	}
	
	@Override public WeightUnitEntity clone() {
		return new WeightUnitEntity(this);
	}
	@Override public String toString() {
		return String.format("WeightUnit[name=%s, plural=%s, abbreviation=%s, normalizing_factor=%s]",
				name, plural, abbreviation, normalizing_factor);
	}
}
