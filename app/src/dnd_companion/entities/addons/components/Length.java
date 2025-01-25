package dnd_companion.entities.addons.components;

import dnd_companion.entities.addons.models.Component;
import dnd_companion.entities.addons.models.types.Measure;
import dnd_companion.entities.unit_related.length.LengthUnitEntity;

public class Length implements Component, Measure
{
	private double value;
	@Override public double value() {return this.value;}

	private LengthUnitEntity unit;
	@Override public LengthUnitEntity unit() {return this.unit;}

	public Length(double value, LengthUnitEntity unit) {
		this.value = value;
		this.unit = unit;
	}
	private Length(Length price) {
		this(price.value, price.unit.clone());
	}

	@Override public Length clone() {
		return new Length(this);
	}
}
