package dnd_companion.actors.entities.system.unit.currency.data;

import dnd_companion.actors.entities.system.unit.currency.CurrencyUnitCentral;
import dnd_companion.actors.entities.system.unit.currency.CurrencyUnitEntity;

public class NormalCurrencyUnit extends CurrencyUnitEntity
{
	public NormalCurrencyUnit() {
		super(CurrencyUnitCentral.use().builder().build());
	}
}
