package dnd_companion.entities.addons.components.measure;

import dnd_companion.entities.addons.models.Component;
import dnd_companion.entities.addons.models.types.Measure;
import dnd_companion.entities.unit_related.time.TimeUnitEntity;

public class Period implements Component, Measure
{
	private double value;
	@Override public double value() {return this.value;}

	private TimeUnitEntity unit;
	@Override public TimeUnitEntity unit() {return this.unit;}

	public Period(double value, TimeUnitEntity unit) {
		this.value = value;
		this.unit = unit;
	}
	private Period(Period price) {
		this(price.value, price.unit.clone());
	}

	@Override public Period clone() {
		return new Period(this);
	}
}
