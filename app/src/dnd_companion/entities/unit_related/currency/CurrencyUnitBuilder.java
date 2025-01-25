package dnd_companion.entities.unit_related.currency;

import dnd_companion.entities.addons.models.EntityBuilder;

public class CurrencyUnitBuilder implements EntityBuilder
{
	private String name = "No name";
	private String singular = "No singular form";
	private String abbreviation = "No abbreviation option";
	private double normalizing_factor = 0;

	CurrencyUnitBuilder() {}

	@Override public CurrencyUnitEntity build() {
		return new CurrencyUnitEntity(name, singular, abbreviation, normalizing_factor);
	}

	public CurrencyUnitBuilder name(String name) {
		this.name = name;
		return this;
	}
	public CurrencyUnitBuilder singular(String singular) {
		this.singular = singular;
		return this;
	}
	public CurrencyUnitBuilder abbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
		return this;
	}
	public CurrencyUnitBuilder normalizing_factor(double normalizing_factor) {
		this.normalizing_factor = normalizing_factor;
		return this;
	}
}
