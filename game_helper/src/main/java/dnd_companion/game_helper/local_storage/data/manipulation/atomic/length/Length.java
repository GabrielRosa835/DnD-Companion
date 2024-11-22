package dnd_companion.game_helper.local_storage.data.manipulation.atomic.length;

import dnd_companion.game_helper.local_storage.data.manipulation.atomic.GroupValue;
import dnd_companion.game_helper.local_storage.data.structure.options.LengthUnit;
import dnd_companion.game_helper.local_storage.data.structure.templates.AtomicOptionUnit;
import dnd_companion.game_helper.local_storage.data_handling.RetrieveOptionsCommand;

public class Length extends GroupValue
{
	@Override public LengthUnit unit() {return (LengthUnit) this.unit();}
	@Override public String unit_group() {return this.unit().group();}
	@Override protected AtomicOptionUnit[] unit_options() {
		return (AtomicOptionUnit[]) new RetrieveOptionsCommand(this.unit_group()).execute().result();
	}

	public Length(double value, String unit) {
		super(value, unit);
	}
}
