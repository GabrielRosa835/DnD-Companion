package dnd_companion.entities.unit_related.currency.data;

import dnd_companion.entities.unit_related.currency.CurrencyUnitCentral;
import dnd_companion.entities.unit_related.currency.CurrencyUnitEntity;

public final class CopperPieces extends CurrencyUnitEntity
{
	public CopperPieces() {
		super(create());
	}
	private static CopperPieces create() {
		return (CopperPieces) new CurrencyUnitCentral().builder()
				.name("Copper piece")
				.plural("Copper pieces")
				.abbreviation("cp")
				.normalizing_factor(1)
				.build();
	}
}
