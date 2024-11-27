package dnd_companion.local_storage.data.manipulation.value_group;

import dnd_companion.local_storage.data.structure.atomic.WeightUnit;
import dnd_companion.local_storage.data.structure.system.units.WeightUnitData;

public class Weight extends ValueGroup<WeightUnit>
{
	@Override public String unit_collection() {return new WeightUnitData().collection();}
	@Override public String unit_name() {return new WeightUnitData().name();}
	@Override public String unit_data_class_name() {return WeightUnitData.class.getName();}

	public Weight() {
		super(0, "normal");
	}
	
	public Weight(double value, String unit) {
		super(value, unit);
	}
}
