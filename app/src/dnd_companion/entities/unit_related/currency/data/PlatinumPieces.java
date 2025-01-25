package dnd_companion.entities.unit_related.currency.data;

import dnd_companion.entities.unit_related.currency.CurrencyUnitCentral;
import dnd_companion.entities.unit_related.currency.CurrencyUnitEntity;

public final class PlatinumPieces extends CurrencyUnitEntity
{
	public PlatinumPieces() {
		super(new CurrencyUnitCentral().builder()
				.name("Platinum pieces")
				.singular("Platinum piece")
				.abbreviation("pp")
				.normalizing_factor(1000)
				.build());
	}
}