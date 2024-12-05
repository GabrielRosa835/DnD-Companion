package dnd_companion.local_storage.structure.data.system.units;

import dnd_companion.local_storage.structure.data.atomic.CurrencyUnit;
import dnd_companion.local_storage.structure.data.templates.OptionData;

public record CurrencyUnitData (CurrencyUnit... options)
implements OptionData<CurrencyUnit>
{
	public CurrencyUnitData() {
		this(
			new CurrencyUnit("Copper Piece", "CP", 1),
			new CurrencyUnit("Silver Piece", "SP", 10),
			new CurrencyUnit("Electurm Piece", "EP", 50),
			new CurrencyUnit("Gold Piece", "GP", 100),
			new CurrencyUnit("Platinum Piece", "PP", 1000)
		);
	}

	@Override
	public String collection() {return "units";}
	@Override
	public String file_name() {return "currencies";}
}
