package dnd_companion.entities.unit_related.currency.data;

import dnd_companion.entities.unit_related.currency.CurrencyUnitCentral;
import dnd_companion.entities.unit_related.currency.CurrencyUnitEntity;

public final class ElectrumPieces extends CurrencyUnitEntity
{
	public ElectrumPieces() {
		super(new CurrencyUnitCentral().builder()
				.name("Electrum pieces")
				.singular("Electrum piece")
				.abbreviation("ep")
				.normalizing_factor(50)
				.build());
	}
}
