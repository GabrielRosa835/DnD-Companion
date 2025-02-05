package dnd_companion.effects.units;

import dnd_companion.actors.models.types.Measure;
import dnd_companion.actors.models.types.Unit;

public class MeasureConverterEffect implements Measure.MeasureEffect
{
	private Measure measure;
	
	private double value;
	private Unit unit;
	
	private Unit newUnit;
	
	private MeasureConverterEffect(Unit newUnit) {
		this.newUnit = newUnit;
	}
	
	@Override public <O> void loadObject(O object) {
		this.measure = (Measure) object;
		this.value = measure.value();
		this.unit = measure.unit();
		this.run();
	}
	@Override public void run() {
		double conversionFactor = newUnit.normalizingFactor() / unit.normalizingFactor();
		value = measure.value() * conversionFactor;
		unit = newUnit;
	}
	
	@Override public double changeValue() {
		return value;
	}
	@Override public Unit changeUnit() {
		return unit;
	}
}
