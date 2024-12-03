package dnd_companion.local_storage.data_structure.java.system.units;

import dnd_companion.local_storage.data_structure.java.templates.UnitGroup;
import dnd_companion.local_storage.data_structure.json.atomic.WeightUnit;
import dnd_companion.local_storage.data_structure.json.system.units.WeightUnitData;
import dnd_companion.local_storage.system_components.DataKey;

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
