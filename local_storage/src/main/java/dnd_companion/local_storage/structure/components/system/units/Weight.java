package dnd_companion.local_storage.structure.components.system.units;

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.structure.components.templates.UnitGroup;
import dnd_companion.local_storage.structure.data.atomic.WeightUnit;
import dnd_companion.local_storage.structure.data.system.units.WeightUnitData;

public class Weight extends UnitGroup<WeightUnit>
{
	@Override
	public DataKey unit_key() {return new DataKey(WeightUnitData.class);}

	public Weight() {
		super(0, "GP");
	}

	public Weight(double value, String unit) {
		super(value, unit);
	}
}
