package dnd_companion.local_storage.structure.components.system.units;

import dnd_companion.local_storage.common.DataKey;
import dnd_companion.local_storage.structure.components.templates.units.UnitGroup;
import dnd_companion.local_storage.structure.data.system.units.CurrencyUnitData;
import dnd_companion.local_storage.structure.data.system.units.CurrencyUnitDataOptions;

public class Price implements UnitGroup<CurrencyUnitData>
{
	private double value = 0;
	public double value() {return this.value;}
	
	@Override
	public DataKey unit_key() {return new DataKey(CurrencyUnitDataOptions.class);}

	public Price() {}
	public Price(double value, String unit) {
		super(value, unit);
	}

	@Override
	public CurrencyUnitData convert_to(String unit_name) {
		// TODO Auto-generated method stub
		return null;
	}
}
