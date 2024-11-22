package dnd_companion.game_helper.local_storage.data.manipulation.atomic.price;

import dnd_companion.game_helper.local_storage.data.manipulation.atomic.GroupValue;
import dnd_companion.game_helper.local_storage.data.structure.options.AtomicOptionUnit;
import dnd_companion.game_helper.local_storage.data.structure.options.PriceUnit;
import dnd_companion.game_helper.local_storage.data_handler.RetrieveOptionsCommand;

public class Price extends GroupValue
{	
	private static final AtomicOptionUnit[] UNIT_OPTIONS = 
			(AtomicOptionUnit[]) new RetrieveOptionsCommand("length_units").execute().result();
	
	@Override protected AtomicOptionUnit[] unit_options() {return UNIT_OPTIONS;}
	@Override public PriceUnit unit() {return (PriceUnit) this.unit();}

	public Price(double value, String unit) {
		super(value, unit);
	}
}
