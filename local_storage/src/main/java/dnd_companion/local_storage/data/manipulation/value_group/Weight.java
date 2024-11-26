package dnd_companion.local_storage.data.manipulation.value_group;

import dnd_companion.local_storage.data.structure.atomic.WeightUnit;
import dnd_companion.local_storage.data.structure.system.units.WeightUnitData;

public class Weight extends ValueGroup<WeightUnit>
{
	@Override public String unit_collection() {return new WeightUnitData().collection();}
	@Override public String unit_name() {return new WeightUnitData().name();}

	public Weight(double value, String unit) {
		super(value, unit);
	}
}
