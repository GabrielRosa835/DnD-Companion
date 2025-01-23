package dnd_companion.entities.unit_related.currency.data;

import dnd_companion.entities.unit_related.currency.CurrencyUnitCentral;
import dnd_companion.entities.unit_related.currency.CurrencyUnitEntity;

public final class GoldPieces extends CurrencyUnitEntity
{
	public GoldPieces() {
		super(create());
	}
	private static GoldPieces create() {
		return (GoldPieces) new CurrencyUnitCentral().builder()
				.name("Gold piece")
				.plural("Gold pieces")
				.abbreviation("gp")
				.normalizing_factor(100)
				.build();
	}
}
