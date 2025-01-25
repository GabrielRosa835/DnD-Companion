package dnd_companion.entities.unit_related.currency;

import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.types.Unit;

public class CurrencyUnitEntity implements Entity, Unit
{
	String name;
	String singular;
	String abbreviation;
	double normalizing_factor;

	@Override public String name() {return name;}
	@Override public String singular() {return singular;}
	@Override public String abbreviation() {return abbreviation;}
	@Override public double normalizing_factor() {return normalizing_factor;}

	CurrencyUnitEntity(String name, String singular, String abbreviation, double normalizing_factor) {
		this.name = name;
		this.singular = singular;
		this.abbreviation = abbreviation;
		this.normalizing_factor = normalizing_factor;
	}
	protected CurrencyUnitEntity(CurrencyUnitEntity entity) {
		this(entity.name, entity.singular, entity.abbreviation, entity.normalizing_factor);
	}

	@Override public CurrencyUnitEntity clone() {
		return new CurrencyUnitEntity(this);
	}
	@Override public String toString() {
		return String.format("CurrencyUnit[name=%s, singular=%s, abbreviation=%s, normalizing_factor=%s]",
				name, singular, abbreviation, normalizing_factor);
	}
}
