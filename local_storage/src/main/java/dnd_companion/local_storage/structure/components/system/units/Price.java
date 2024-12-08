package dnd_companion.local_storage.structure.components.system.units;

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.structure.components.templates.UnitGroup;
import dnd_companion.local_storage.structure.data.system.units.CurrencyData;
import dnd_companion.local_storage.structure.data.system.units.CurrencyUnitDataOptions;

public class Price extends UnitGroup<CurrencyData>
{
	@Override
	public DataKey unit_key() {return new DataKey(CurrencyUnitDataOptions.class);}

	public Price() {
		super(0, "GP");
	}
	public Price(double value, String unit) {
		super(value, unit);
	}
}
