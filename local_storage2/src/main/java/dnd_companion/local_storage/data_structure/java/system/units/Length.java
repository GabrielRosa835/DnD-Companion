package dnd_companion.local_storage.data_structure.java.system.units;

import dnd_companion.local_storage.data_structure.java.templates.UnitGroup;
import dnd_companion.local_storage.data_structure.json.atomic.LengthUnit;
import dnd_companion.local_storage.data_structure.json.system.units.LengthUnitData;
import dnd_companion.local_storage.system_components.DataKey;

public class Length extends UnitGroup<LengthUnit>
{
	@Override
	public DataKey unit_key() {return new DataKey(LengthUnitData.class);}

	public Length() {
		super(0, "GP");
	}
	public Length(double value, String unit) {
		super(value, unit);
	}
}
