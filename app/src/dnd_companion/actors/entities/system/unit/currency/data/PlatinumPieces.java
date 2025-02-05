package dnd_companion.actors.entities.system.unit.currency.data;

import dnd_companion.actors.entities.system.unit.currency.CurrencyUnitCentral;
import dnd_companion.actors.entities.system.unit.currency.CurrencyUnitEntity;

public final class PlatinumPieces extends CurrencyUnitEntity
{
	public PlatinumPieces() {
		super(CurrencyUnitCentral.use().builder()
				.name("Platinum pieces")
				.singularForm("Platinum piece")
				.abbreviation("pp")
				.normalizingFactor(1000)
				.build());
	}
}