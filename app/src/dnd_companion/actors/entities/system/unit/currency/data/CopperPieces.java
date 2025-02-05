package dnd_companion.actors.entities.system.unit.currency.data;

import dnd_companion.actors.entities.system.unit.currency.CurrencyUnitCentral;
import dnd_companion.actors.entities.system.unit.currency.CurrencyUnitEntity;

public final class CopperPieces extends CurrencyUnitEntity
{
	public CopperPieces() {
		super(CurrencyUnitCentral.use().builder()
				.name("Copper pieces")
				.singularForm("Copper piece")
				.abbreviation("cp")
				.normalizingFactor(1)
				.build());
	}
}
