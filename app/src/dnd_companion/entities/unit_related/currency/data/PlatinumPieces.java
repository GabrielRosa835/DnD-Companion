package dnd_companion.entities.unit_related.currency.data;

import dnd_companion.entities.unit_related.currency.CurrencyUnitCentral;
import dnd_companion.entities.unit_related.currency.CurrencyUnitEntity;

public final class PlatinumPieces extends CurrencyUnitEntity
{
	public PlatinumPieces() {
		super(create());
	}
	private static PlatinumPieces create() {
		return (PlatinumPieces) new CurrencyUnitCentral().builder()
				.name("Platinum piece")
				.plural("Platinum pieces")
				.abbreviation("pp")
				.normalizing_factor(1000)
				.build();
	}
}