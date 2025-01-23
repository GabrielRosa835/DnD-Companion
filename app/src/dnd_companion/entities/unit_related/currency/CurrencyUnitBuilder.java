package dnd_companion.entities.unit_related.currency;

import dnd_companion.entities.addons.models.EntityBuilder;

public class CurrencyUnitBuilder implements EntityBuilder
{
	private String name = "No name";
	private String plural = "No plural option";
	private String abbreviation = "No abbreviation option";
	private double normalizing_factor = 0;
	
	CurrencyUnitBuilder() {}

	@Override public CurrencyUnitEntity build() {
		return new CurrencyUnitEntity(name, plural, abbreviation, normalizing_factor);
	}
	
	public CurrencyUnitBuilder name(String name) {
		this.name = name;
		return this;
	}
	public CurrencyUnitBuilder plural(String plural) {
		this.plural = plural;
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
