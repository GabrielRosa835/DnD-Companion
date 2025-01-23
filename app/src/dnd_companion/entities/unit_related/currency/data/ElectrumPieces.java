package dnd_companion.entities.unit_related.currency.data;

import dnd_companion.entities.unit_related.currency.CurrencyUnitCentral;
import dnd_companion.entities.unit_related.currency.CurrencyUnitEntity;

public final class ElectrumPieces extends CurrencyUnitEntity
{
	public ElectrumPieces() {
		super(create());
	}
	private static ElectrumPieces create() {
		return (ElectrumPieces) new CurrencyUnitCentral().builder()
				.name("Electrum piece")
				.plural("Electrum pieces")
				.abbreviation("ep")
				.normalizing_factor(50)
				.build();
	}
}
