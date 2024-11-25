package dnd_companion.local_storage.data.manipulation.price;

import dnd_companion.local_storage.data.manipulation.ValueGroup;
import dnd_companion.local_storage.data.structure.templates.AtomicOptionUnit;
import dnd_companion.local_storage.data.structure.units.Currency;
import dnd_companion.local_storage.data_handling.DataHandler;

public class Price extends ValueGroup
{		
	@Override public Currency unit() {return (Currency) this.unit;}
	@Override public String unit_group() {return Currency.GROUP;}
	@Override protected AtomicOptionUnit[] unit_options() {
		return DataHandler.retrieve_units(this.unit_group());
	}

	public Price(double value, String unit) {
		super(value, unit);
	}
}
