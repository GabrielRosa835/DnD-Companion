package dnd_companion.actors.components.measure;

import dnd_companion.actors.entities.system.unit.currency.CurrencyUnitEntity;
import dnd_companion.actors.models.IComponent;
import dnd_companion.actors.models.types.Measure;
import dnd_companion.effects.IEffect;
import dnd_companion.effects.Effectable;

public class Price implements IComponent, Measure, Effectable
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
	@Override public String toString() {
		return String.format("Price[value=%.2f, unit=%s]",
				value, unit.toString());
	}
	@Override public Price applyEffect(IEffect e) {
		PriceEffect effect = (PriceEffect) e;
		effect.loadObject(this);
		this.value = effect.changeValue();
		this.unit = (CurrencyUnitEntity) effect.changeUnit();
		return this;
	}
	
	public interface PriceEffect extends Measure.MeasureEffect {}
}
