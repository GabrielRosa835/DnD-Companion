package dnd_companion.entities.unit_related.length;

import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.types.Unit;

public class LengthUnitEntity implements Entity, Unit
{
	String name;
	String singular;
	String abbreviation;
	double normalizing_factor;

	@Override public String name() {return name;}
	@Override public String singular() {return singular;}
	@Override public String abbreviation() {return abbreviation;}
	@Override public double normalizing_factor() {return normalizing_factor;}

	LengthUnitEntity(String name, String singular, String abbreviation, double normalizing_factor) {
		this.name = name;
		this.singular = singular;
		this.abbreviation = abbreviation;
		this.normalizing_factor = normalizing_factor;
	}
	protected LengthUnitEntity(LengthUnitEntity entity) {
		this.name = entity.name;
		this.singular = entity.singular;
		this.abbreviation = entity.abbreviation;
		this.normalizing_factor = entity.normalizing_factor;
	}

	@Override public String toString() {
		return String.format("LengthUnit[name=%s, singular=%s, abbreviation=%s, normalizing_factor=%s]",
				name, singular, abbreviation, normalizing_factor);
	}
	@Override public LengthUnitEntity clone() {
		return new LengthUnitEntity(this);
	}
}
