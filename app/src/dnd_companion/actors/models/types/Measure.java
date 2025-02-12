package dnd_companion.actors.models.types;

import dnd_companion.effects.IEffect;

public interface Measure
{
	public double value();
	public Unit unit();
	
	public interface MeasureEffect extends IEffect {
		public double changeValue();
		public Unit changeUnit();
	}
 }
