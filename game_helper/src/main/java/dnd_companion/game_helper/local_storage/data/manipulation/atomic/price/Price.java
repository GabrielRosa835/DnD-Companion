package dnd_companion.game_helper.local_storage.data.manipulation.atomic.price;

import dnd_companion.game_helper.local_storage.data.manipulation.atomic.GroupValue;
import dnd_companion.game_helper.local_storage.data.structure.options.Currency;
import dnd_companion.game_helper.local_storage.data.structure.templates.AtomicOptionUnit;
import dnd_companion.game_helper.local_storage.data_handling.RetrieveOptionsCommand;

public class Price extends GroupValue
{			
	@Override public Currency unit() {return (Currency) this.unit();}
	@Override public String unit_group() {return this.unit().group();}
	@Override protected AtomicOptionUnit[] unit_options() {
		return (AtomicOptionUnit[]) new RetrieveOptionsCommand(this.unit_group()).execute().result();
	}

	public Price(double value, String unit) {
		super(value, unit);
	}
}
