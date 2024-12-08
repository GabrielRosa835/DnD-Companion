package dnd_companion.local_storage.structure.components.system.units;

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.structure.components.templates.UnitGroup;
import dnd_companion.local_storage.structure.data.system.units.LengthUnitData;
import dnd_companion.local_storage.structure.data.system.units.LengthUnitDataOptions;

public class Length extends UnitGroup<LengthUnitData>
{
	@Override
	public DataKey unit_key() {return new DataKey(LengthUnitDataOptions.class);}

	public Length() {
		super(0, "GP");
	}
	public Length(double value, String unit) {
		super(value, unit);
	}
}
