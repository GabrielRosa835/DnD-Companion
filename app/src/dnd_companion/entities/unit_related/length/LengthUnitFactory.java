package dnd_companion.entities.unit_related.length;

import java.util.Arrays;
import java.util.List;

import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.EntityFactory;
import dnd_companion.entities.unit_related.length.data.Centimeters;
import dnd_companion.entities.unit_related.length.data.Feet;
import dnd_companion.entities.unit_related.length.data.Inches;
import dnd_companion.entities.unit_related.length.data.Meters;
import dnd_companion.entities.unit_related.length.data.Squares;

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
