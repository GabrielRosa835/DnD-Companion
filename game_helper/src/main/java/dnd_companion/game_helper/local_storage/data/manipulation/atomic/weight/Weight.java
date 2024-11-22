package dnd_companion.game_helper.local_storage.data.manipulation.atomic.weight;

import dnd_companion.game_helper.local_storage.data.manipulation.atomic.GroupValue;
import dnd_companion.game_helper.local_storage.data.structure.options.WeightUnit;
import dnd_companion.game_helper.local_storage.data.structure.templates.AtomicOptionUnit;
import dnd_companion.game_helper.local_storage.data_handling.RetrieveOptionsCommand;

public class Weight extends GroupValue
{
	@Override public WeightUnit unit() {return (WeightUnit) this.unit();}
	@Override public String unit_group() {return this.unit().group();}
	@Override protected AtomicOptionUnit[] unit_options() {
		return (AtomicOptionUnit[]) new RetrieveOptionsCommand(this.unit_group()).execute().result();
	}

	public Weight(double value, String unit) {
		super(value, unit);
	}
}
