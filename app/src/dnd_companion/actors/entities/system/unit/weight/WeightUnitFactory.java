package dnd_companion.actors.entities.system.unit.weight;

import java.util.Arrays;
import java.util.List;

import dnd_companion.actors.entities.system.unit.weight.data.NormalWeightUnit;
import dnd_companion.actors.entities.system.unit.weight.data.Grams;
import dnd_companion.actors.entities.system.unit.weight.data.Kilograms;
import dnd_companion.actors.entities.system.unit.weight.data.Ounces;
import dnd_companion.actors.entities.system.unit.weight.data.Pounds;
import dnd_companion.actors.models.Entity;
import dnd_companion.actors.models.EntityFactory;

public class WeightUnitFactory implements EntityFactory
{
	WeightUnitFactory() {}

	@Override public List<Entity> dataList() {
		return Arrays.asList(grams(), kilograms(), ounces(), pounds());
	}
	@Override public Entity defaultData() {
		return new NormalWeightUnit();
	}

	public WeightUnitEntity grams() {
		return new Grams();
	}
	public WeightUnitEntity kilograms() {
		return new Kilograms();
	}
	public WeightUnitEntity ounces() {
		return new Ounces();
	}
	public WeightUnitEntity pounds() {
		return new Pounds();
	}
}
