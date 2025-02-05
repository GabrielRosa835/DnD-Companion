package dnd_companion.actors.entities.system.unit.currency.data;

import dnd_companion.actors.entities.system.unit.currency.CurrencyUnitCentral;
import dnd_companion.actors.entities.system.unit.currency.CurrencyUnitEntity;

public final class GoldPieces extends CurrencyUnitEntity
{
	public GoldPieces() {
		super(CurrencyUnitCentral.use().builder()
				.name("Gold pieces")
				.singularForm("Gold piece")
				.abbreviation("gp")
				.normalizingFactor(100)
				.build());
	}
}
