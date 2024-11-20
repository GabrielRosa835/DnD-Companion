package dnd_companion.game_helper.local_storage.data_structure.archived.atomic.currency;

import dnd_companion.tool_kit.data_structure.atomic.NormalizeableGroup;

public class CurrencyGroup extends NormalizeableGroup<Currency, CurrencyGroup>
{	
	public CurrencyGroup(Currency currency, double value) {
		this.element = currency;
		this.value = value;
	}
	
	@Override
	public CurrencyGroup convert_to(Currency currency) {
		return new CurrencyGroup(currency, Math.floor(this.normalized().value() / currency.normalizing_factor()));
	}

	@Override
	public CurrencyGroup normalized() {
		return new CurrencyGroup(, this.value * this.element.normalizing_factor());
	}
}
