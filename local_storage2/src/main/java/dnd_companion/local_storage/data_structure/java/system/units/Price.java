package dnd_companion.local_storage.data_structure.java.system.units;

import dnd_companion.local_storage.data_structure.java.templates.UnitGroup;
import dnd_companion.local_storage.data_structure.json.atomic.CurrencyUnit;
import dnd_companion.local_storage.data_structure.json.system.units.CurrencyUnitData;
import dnd_companion.local_storage.system_components.DataKey;

public class Price extends UnitGroup<CurrencyUnit>
{
	@Override
	public DataKey unit_key() {return new DataKey(CurrencyUnitData.class);}

	public Price() {
		super(0, "GP");
	}
	public Price(double value, String unit) {
		super(value, unit);
	}
}
