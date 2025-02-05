package dnd_companion.actors.components.weapon;

import dnd_companion.actors.components.measure.Length;
import dnd_companion.actors.models.Component;
import dnd_companion.effects.Effect;
import dnd_companion.effects.Effectable;

public class WeaponRange implements Component, Effectable
{
	private Length minRange;
	private Length maxRange;
	
	public Length minRange() {return minRange;}
	public Length maxRange() {return maxRange;}
	
	public WeaponRange(Length minRange, Length maxRange) {
		this.minRange = minRange;
		this.maxRange = maxRange;
	}
	private WeaponRange(WeaponRange clone) {
		this.minRange = clone.minRange.clone();
		this.maxRange = clone.maxRange.clone();
	}
	
	@Override public WeaponRange clone() {
		return new WeaponRange(this);
	}
	@Override public WeaponRange applyEffect(Effect effect) {
		InterEffect e = (InterEffect) effect;
		e.loadObject(this);
		this.minRange = e.changeMinRange();
		this.maxRange = e.changeMaxRange();
		return this;
	}
	
	public interface InterEffect extends Effect {
		public Length changeMinRange();
		public Length changeMaxRange();
	}
}
