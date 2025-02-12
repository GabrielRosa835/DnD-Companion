package dnd_companion.actors.components.measure;

import dnd_companion.actors.entities.system.unit.weight.WeightUnitEntity;
import dnd_companion.actors.models.IComponent;
import dnd_companion.actors.models.types.Measure;
import dnd_companion.effects.IEffect;
import dnd_companion.effects.Effectable;

public class Weight implements IComponent, Measure, Effectable
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
	@Override public String toString() {
		return String.format("Weight[value=%.2f, unit=%s]",
				value, unit.toString());
	}
	
	@Override public Weight applyEffect(IEffect e) {
		WeightEffect effect = (WeightEffect) e;
		effect.loadObject(this);
		this.value = effect.changeValue();
		this.unit = (WeightUnitEntity) effect.changeUnit();
		return this;
	}
	
	public interface WeightEffect extends Measure.MeasureEffect {}
}
