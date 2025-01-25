package dnd_companion.entities.addons.components;

import dnd_companion.entities.addons.models.Component;
import dnd_companion.entities.addons.models.types.Measure;
import dnd_companion.entities.unit_related.weight.WeightUnitEntity;

public class Weight implements Component, Measure
{
	private double value;
	@Override public double value() {return this.value;}

	private WeightUnitEntity unit;
	@Override public WeightUnitEntity unit() {return this.unit;}

	public Weight(double value, WeightUnitEntity unit) {
		this.value = value;
		this.unit = unit;
	}
	private Weight(Weight Weight) {
		this(Weight.value, Weight.unit.clone());
	}

	@Override public Weight clone() {
		return new Weight(this);
	}
}
