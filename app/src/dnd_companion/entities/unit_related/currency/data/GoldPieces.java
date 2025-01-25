package dnd_companion.entities.unit_related.currency.data;

import dnd_companion.entities.unit_related.currency.CurrencyUnitCentral;
import dnd_companion.entities.unit_related.currency.CurrencyUnitEntity;

public final class GoldPieces extends CurrencyUnitEntity
{
	public GoldPieces() {
		super(new CurrencyUnitCentral().builder()
				.name("Gold pieces")
				.singular("Gold piece")
				.abbreviation("gp")
				.normalizing_factor(100)
				.build());
	}
}
