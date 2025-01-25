package dnd_companion.entities.unit_related.currency.data;

import dnd_companion.entities.unit_related.currency.CurrencyUnitCentral;
import dnd_companion.entities.unit_related.currency.CurrencyUnitEntity;

public final class SilverPieces extends CurrencyUnitEntity
{
	public SilverPieces() {
		super(new CurrencyUnitCentral().builder()
				.name("Silver pieces")
				.singular("Silver piece")
				.abbreviation("sp")
				.normalizing_factor(10)
				.build());
	}
}