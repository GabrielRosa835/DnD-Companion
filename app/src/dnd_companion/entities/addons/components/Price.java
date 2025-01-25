package dnd_companion.entities.addons.components;

import dnd_companion.entities.addons.models.Component;
import dnd_companion.entities.addons.models.types.Measure;
import dnd_companion.entities.unit_related.currency.CurrencyUnitEntity;

public class Price implements Component, Measure
{
	private double value;
	@Override public double value() {return this.value;}

	private CurrencyUnitEntity unit;
	@Override public CurrencyUnitEntity unit() {return this.unit;}

	public Price(double value, CurrencyUnitEntity unit) {
		this.value = value;
		this.unit = unit;
	}
	private Price(Price price) {
		this(price.value, price.unit.clone());
	}

	@Override public Price clone() {
		return new Price(this);
	}
}
