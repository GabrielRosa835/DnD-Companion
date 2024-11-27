package dnd_companion.local_storage.data.manipulation.value_group;

import dnd_companion.local_storage.data.structure.atomic.Currency;
import dnd_companion.local_storage.data.structure.system.units.CurrencyData;

public class Price extends ValueGroup<Currency>
{		
	@Override public String unit_collection() {return new CurrencyData().collection();}
	@Override public String unit_name() {return new CurrencyData().name();}
	@Override public String unit_data_class_name() {return CurrencyData.class.getName();}

	public Price() {
		super(0, "normal");
	}
	
	public Price(double value, String unit) {
		super(value, unit);
	}
}
