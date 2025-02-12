package dnd_companion.actors.components.measure;

import dnd_companion.actors.entities.system.unit.time.TimeUnitEntity;
import dnd_companion.actors.models.IComponent;
import dnd_companion.actors.models.types.Measure;
import dnd_companion.effects.IEffect;
import dnd_companion.effects.Effectable;

public class Period implements IComponent, Measure, Effectable
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
	@Override public String toString() {
		return String.format("Period[value=%.2f, unit=%s]",
				value, unit.toString());
	}
	
	@Override public Period applyEffect(IEffect e) {
		PeriodEffect effect = (PeriodEffect) e;
		effect.loadObject(this);
		this.value = effect.changeValue();
		this.unit = (TimeUnitEntity) effect.changeUnit();
		return this;
	}
	
	public interface PeriodEffect extends Measure.MeasureEffect {}
}
