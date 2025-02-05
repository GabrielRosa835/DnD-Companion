package dnd_companion.actors.entities.system.unit.length;

import java.util.Arrays;
import java.util.List;

import dnd_companion.actors.entities.system.unit.length.data.Centimeters;
import dnd_companion.actors.entities.system.unit.length.data.Feet;
import dnd_companion.actors.entities.system.unit.length.data.Inches;
import dnd_companion.actors.entities.system.unit.length.data.Meters;
import dnd_companion.actors.entities.system.unit.length.data.Squares;
import dnd_companion.actors.models.Entity;
import dnd_companion.actors.models.EntityFactory;

public class LengthUnitFactory implements EntityFactory
{
	LengthUnitFactory() {}

	@Override public List<Entity> dataList() {
		return Arrays.asList(centimeters(), meters(), inches(), feet(), squares());
	}
	@Override public LengthUnitEntity defaultData() {
		return new LengthUnitBuilder().build();
	}

	public LengthUnitEntity centimeters() {
		return new Centimeters();
	}
	public LengthUnitEntity meters() {
		return new Meters();
	}
	public LengthUnitEntity inches() {
		return new Inches();
	}
	public LengthUnitEntity feet() {
		return new Feet();
	}
	public LengthUnitEntity squares() {
		return new Squares();
	}
}
