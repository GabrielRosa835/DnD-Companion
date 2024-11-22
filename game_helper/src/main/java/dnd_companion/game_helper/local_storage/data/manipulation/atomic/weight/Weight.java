package dnd_companion.game_helper.local_storage.data.manipulation.atomic.weight;

import dnd_companion.game_helper.local_storage.data.manipulation.atomic.GroupValue;
import dnd_companion.game_helper.local_storage.data.structure.options.AtomicOptionUnit;
import dnd_companion.game_helper.local_storage.data.structure.options.WeightUnit;
import dnd_companion.game_helper.local_storage.data_handler.RetrieveOptionsCommand;

public class Weight extends GroupValue
{
	private static final AtomicOptionUnit[] UNIT_OPTIONS = 
			(AtomicOptionUnit[]) new RetrieveOptionsCommand("weight_units").execute().result();
	
	@Override protected AtomicOptionUnit[] unit_options() {return UNIT_OPTIONS;}
	@Override public WeightUnit unit() {return (WeightUnit) this.unit();}

	public Weight(double value, String unit) {
		super(value, unit);
	}
}
