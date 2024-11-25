package dnd_companion.local_storage.data.manipulation.weight;

import dnd_companion.local_storage.data.manipulation.ValueGroup;
import dnd_companion.local_storage.data.structure.templates.AtomicOptionUnit;
import dnd_companion.local_storage.data.structure.units.WeightUnit;
import dnd_companion.local_storage.data_handling.DataHandler;

public class Weight extends ValueGroup
{
	@Override public WeightUnit unit() {return (WeightUnit) this.unit;}
	@Override public String unit_group() {return WeightUnit.GROUP;}
	@Override protected AtomicOptionUnit[] unit_options() {
		return DataHandler.retrieve_units(this.unit_group());
	}

	public Weight(double value, String unit) {
		super(value, unit);
	}
}
