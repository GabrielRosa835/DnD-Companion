package dnd_companion.local_storage.structure.components.system.units;

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.structure.components.templates.UnitGroup;
import dnd_companion.local_storage.structure.data.atomic.LengthUnit;
import dnd_companion.local_storage.structure.data.system.units.LengthUnitData;

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
