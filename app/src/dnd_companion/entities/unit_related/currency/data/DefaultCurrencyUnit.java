package dnd_companion.entities.unit_related.currency.data;

import dnd_companion.entities.unit_related.currency.CurrencyUnitCentral;
import dnd_companion.entities.unit_related.currency.CurrencyUnitEntity;

public class DefaultCurrencyUnit extends CurrencyUnitEntity
{
	public DefaultCurrencyUnit() {
		super(new CurrencyUnitCentral().builder()
				.name("No Currency")
				.singular("No Currency")
				.abbreviation("No Currency")
				.normalizing_factor(0)
				.build());
	}
}
