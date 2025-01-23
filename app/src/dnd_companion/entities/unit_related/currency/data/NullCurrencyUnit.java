package dnd_companion.entities.unit_related.currency.data;

import dnd_companion.entities.unit_related.currency.CurrencyUnitCentral;
import dnd_companion.entities.unit_related.currency.CurrencyUnitEntity;

public final class NullCurrencyUnit extends CurrencyUnitEntity
{
	public NullCurrencyUnit() {
		super(create());
	}
	private static NullCurrencyUnit create() {
		return (NullCurrencyUnit) new CurrencyUnitCentral().builder()
				.name("None")
				.plural("None")
				.abbreviation("none")
				.normalizing_factor(0)
				.build();
	}
}
