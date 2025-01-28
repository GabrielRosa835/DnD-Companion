package dnd_companion.entities.addons.models.types;

import dnd_companion.effects.Effect;
import dnd_companion.entities.unit_related.length.LengthUnitEntity;

public interface Measure
{
	public double value();
	public Unit unit();
	
	public interface ValueChanger extends Effect {
		public double changeValue();
	}
	public interface UnitChanger extends Effect {
		public LengthUnitEntity changeUnit();
		public double changeValue();
	}
}
