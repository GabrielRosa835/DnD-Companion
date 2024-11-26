package dnd_companion.local_storage.data.manipulation.value_group;

import dnd_companion.local_storage.data.structure.atomic.Currency;
import dnd_companion.local_storage.data.structure.system.units.CurrencyData;

public class Price extends ValueGroup<Currency>
{		
	@Override public String unit_collection() {return new CurrencyData().collection();}
	@Override public String unit_name() {return new CurrencyData().name();}

	public Price(double value, String unit) {
		super(value, unit);
	}
}
