package atomic.currency;

import atomic.Bundle;
import atomic.Group.NormalizeableGroup;

public class CurrencyBundle extends Bundle<Currency> implements NormalizeableGroup<Integer, Currency, CurrencyBundle>
{	
	public CurrencyBundle(Currency currency, int amount) {
		this.element = currency;
		this.amount = amount;
	}
	
	@Override
	public void convert_to(Currency currency) {
		this.amount = (int) this.normalized() / this.element.normalizing_factor();
		this.element = currency;
	}

	@Override
	public CurrencyBundle convert_new(Currency currency) {
		return new CurrencyBundle(element, (int) Math.floor(this.normalized() / currency.normalizing_factor()));
	}

	@Override
	public Integer normalized() {
		return this.amount * this.element.normalizing_factor();
	}
}
