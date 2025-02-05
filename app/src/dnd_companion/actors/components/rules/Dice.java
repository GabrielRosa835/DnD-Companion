package dnd_companion.actors.components.rules;

import dnd_companion.actors.models.Component;
import dnd_companion.effects.Effect;

public class Dice implements Component
{
	private int maximumValue;
	
	public int maximumValue() {return maximumValue;}
	public String name() {return "d" + maximumValue;}
	
	public Dice(int maximumValue) {
		this.maximumValue = maximumValue;
	}
	private Dice(Dice clone) {
		this.maximumValue = clone.maximumValue;
	}
	
	@Override public Dice clone() {
		return new Dice(this);
	}
	
	public interface InterEffect extends Effect {
		public int changeMaximumValue();
	}
}
