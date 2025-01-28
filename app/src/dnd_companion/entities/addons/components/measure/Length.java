package dnd_companion.entities.addons.components.measure;

import dnd_companion.entities.addons.models.Component;
import dnd_companion.entities.addons.models.types.Measure;
import dnd_companion.entities.unit_related.length.LengthUnitEntity;

public class Length implements Component, Measure
{
	private double value;
	private LengthUnitEntity unit;

	@Override public double value() {return this.value;}
	@Override public LengthUnitEntity unit() {return this.unit;}
	
	public Length value(Length.ValueChanger valueChanger) {
		valueChanger.loadObject(this);
		this.value = valueChanger.changeValue();
		return this;
	}
	public Length convert(Length.UnitChanger unitChanger) {
		unitChanger.loadObject(this);
		this.unit = unitChanger.changeUnit();
		this.value = unitChanger.changeValue();
		return this;
	}

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
	
	public interface ValueChanger extends Measure.ValueChanger {
		@Override public double changeValue();
	}
	public interface UnitChanger extends Measure.UnitChanger {
		@Override public LengthUnitEntity changeUnit();
		@Override public double changeValue();
	}
	
//	private static double calculateNewValue(Measure measure, Unit unit) {
//		double conversionFactor = unit.normalizing_factor() / measure.unit().normalizing_factor();
//		double newValue = measure.value() * conversionFactor;
//		return newValue;
//	}
}
