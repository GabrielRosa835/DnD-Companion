package dnd_companion.actors.components.measure;

import dnd_companion.actors.entities.system.unit.length.LengthUnitEntity;
import dnd_companion.actors.models.IComponent;
import dnd_companion.actors.models.types.Measure;
import dnd_companion.effects.IEffect;
import dnd_companion.effects.Effectable;

public class Length implements IComponent, Measure, Effectable
{
	private double value;
	private LengthUnitEntity unit;

	@Override public double value() {return this.value;}
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
	@Override public String toString() {
		return String.format("Length[value=%.2f, unit=%s]",
				value, unit.toString());
	}
	
	@Override public Length applyEffect(IEffect e) {
		LengthEffect effect = (LengthEffect) e;
		effect.loadObject(this);
		this.value = effect.changeValue();
		this.unit = (LengthUnitEntity) effect.changeUnit();
		return this;
	}
	
	public interface LengthEffect extends Measure.MeasureEffect {}
}
