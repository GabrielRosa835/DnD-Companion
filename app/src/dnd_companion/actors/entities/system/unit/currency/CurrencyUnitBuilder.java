package dnd_companion.actors.entities.system.unit.currency;

import dnd_companion.actors.models.EntityBuilder;

public class CurrencyUnitBuilder implements EntityBuilder
{
	private String name = "Normal";
	private String singularForm = "Normal";
	private String abbreviation = "norm";
	private double normalizingFactor = 1;

	CurrencyUnitBuilder() {}

	@Override public CurrencyUnitEntity build() {
		return new CurrencyUnitEntity(name, singularForm, abbreviation, normalizingFactor);
	}

	public CurrencyUnitBuilder name(String name) {
		this.name = name;
		return this;
	}
	public CurrencyUnitBuilder singularForm(String singularForm) {
		this.singularForm = singularForm;
		return this;
	}
	public CurrencyUnitBuilder abbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
		return this;
	}
	public CurrencyUnitBuilder normalizingFactor(double normalizingFactor) {
		this.normalizingFactor = normalizingFactor;
		return this;
	}
}
