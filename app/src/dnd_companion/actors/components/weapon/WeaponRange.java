package dnd_companion.actors.components.weapon;

import dnd_companion.actors.components.measure.Length;
import dnd_companion.actors.models.IComponent;
import dnd_companion.effects.IEffect;
import dnd_companion.effects.Effectable;

public class WeaponRange implements IComponent, Effectable
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
	@Override public WeaponRange applyEffect(IEffect effect) {
		InterEffect e = (InterEffect) effect;
		e.loadObject(this);
		this.minRange = e.changeMinRange();
		this.maxRange = e.changeMaxRange();
		return this;
	}
	
	public interface InterEffect extends IEffect {
		public Length changeMinRange();
		public Length changeMaxRange();
	}
}
