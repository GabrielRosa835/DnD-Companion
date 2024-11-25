package dnd_companion.local_storage.data.manipulation.length;

import dnd_companion.local_storage.data.manipulation.ValueGroup;
import dnd_companion.local_storage.data.structure.templates.AtomicOptionUnit;
import dnd_companion.local_storage.data.structure.units.LengthUnit;
import dnd_companion.local_storage.data_handling.DataHandler;

public class Length extends ValueGroup
{
	@Override public LengthUnit unit() {return (LengthUnit) this.unit;}
	@Override public String unit_group() {return LengthUnit.GROUP;}
	@Override protected AtomicOptionUnit[] unit_options() {
		return DataHandler.retrieve_units(this.unit_group());
	}

	public Length(double value, String unit) {
		super(value, unit);
	}
}
