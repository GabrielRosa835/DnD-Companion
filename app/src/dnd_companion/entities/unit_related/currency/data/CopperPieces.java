package dnd_companion.entities.unit_related.currency.data;

import dnd_companion.entities.unit_related.currency.CurrencyUnitCentral;
import dnd_companion.entities.unit_related.currency.CurrencyUnitEntity;

public final class CopperPieces extends CurrencyUnitEntity
{
	public CopperPieces() {
		super(new CurrencyUnitCentral().builder()
				.name("Copper pieces")
				.singular("Copper piece")
				.abbreviation("cp")
				.normalizing_factor(1)
				.build());
	}
}
