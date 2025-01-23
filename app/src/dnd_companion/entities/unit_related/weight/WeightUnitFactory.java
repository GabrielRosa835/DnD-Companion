package dnd_companion.entities.unit_related.weight;

import java.util.Arrays;
import java.util.List;

import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.EntityFactory;
import dnd_companion.entities.unit_related.weight.data.Grams;
import dnd_companion.entities.unit_related.weight.data.Kilograms;
import dnd_companion.entities.unit_related.weight.data.NullWeightUnit;
import dnd_companion.entities.unit_related.weight.data.Ounces;
import dnd_companion.entities.unit_related.weight.data.Pounds;

public class WeightUnitFactory implements EntityFactory
{
	WeightUnitFactory() {}
	
	@Override public List<Entity> dataList() {
		return Arrays.asList(nullWeightUnit(), grams(), kilograms(), ounces(), pounds());
	}
	
	public WeightUnitEntity nullWeightUnit() {
		return new NullWeightUnit();
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
