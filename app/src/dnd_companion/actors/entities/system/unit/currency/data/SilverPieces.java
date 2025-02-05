package dnd_companion.actors.entities.system.unit.currency.data;

import dnd_companion.actors.entities.system.unit.currency.CurrencyUnitCentral;
import dnd_companion.actors.entities.system.unit.currency.CurrencyUnitEntity;

public final class SilverPieces extends CurrencyUnitEntity
{
	public SilverPieces() {
		super(CurrencyUnitCentral.use().builder()
				.name("Silver pieces")
				.singularForm("Silver piece")
				.abbreviation("sp")
				.normalizingFactor(10)
				.build());
	}
}