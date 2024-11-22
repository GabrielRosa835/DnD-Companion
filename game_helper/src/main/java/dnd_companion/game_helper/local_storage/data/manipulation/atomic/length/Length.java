package dnd_companion.game_helper.local_storage.data.manipulation.atomic.length;

import dnd_companion.game_helper.local_storage.data.manipulation.atomic.GroupValue;
import dnd_companion.game_helper.local_storage.data.structure.options.AtomicOptionUnit;
import dnd_companion.game_helper.local_storage.data.structure.options.LengthUnit;
import dnd_companion.game_helper.local_storage.data_handler.RetrieveOptionsCommand;

public class Length extends GroupValue
{
	private static final AtomicOptionUnit[] UNIT_OPTIONS = 
			(AtomicOptionUnit[]) new RetrieveOptionsCommand("length_units").execute().result();
	
	@Override protected AtomicOptionUnit[] unit_options() {return UNIT_OPTIONS;}
	@Override public LengthUnit unit() {return (LengthUnit) this.unit();}

	public Length(double value, String unit) {
		super(value, unit);
	}
}
