package dnd_companion.actors.models.types;

import dnd_companion.effects.Effect;

public interface Measure
{
	public double value();
	public Unit unit();
	
	public interface MeasureEffect extends Effect {
		public double changeValue();
		public Unit changeUnit();
	}
 }
