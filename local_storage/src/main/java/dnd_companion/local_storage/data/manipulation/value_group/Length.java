package dnd_companion.local_storage.data.manipulation.value_group;

import dnd_companion.local_storage.data.structure.atomic.LengthUnit;
import dnd_companion.local_storage.data.structure.system.units.LengthUnitData;

public class Length extends ValueGroup<LengthUnit>
{
	@Override public String unit_collection() {return new LengthUnitData().collection();}
	@Override public String unit_name() {return new LengthUnitData().name();}
	@Override public String unit_data_class_name() {return LengthUnitData.class.getName();}

	public Length() {
		super(0, "normal");
	}
	
	public Length(double value, String unit) {
		super(value, unit);
	}
}
