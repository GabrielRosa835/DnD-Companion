package dnd_companion.actors.entities.system.unit.currency.data;

import dnd_companion.actors.entities.system.unit.currency.CurrencyUnitCentral;
import dnd_companion.actors.entities.system.unit.currency.CurrencyUnitEntity;

public final class ElectrumPieces extends CurrencyUnitEntity
{
	public ElectrumPieces() {
		super(CurrencyUnitCentral.use().builder()
				.name("Electrum pieces")
				.singularForm("Electrum piece")
				.abbreviation("ep")
				.normalizingFactor(50)
				.build());
	}
}
