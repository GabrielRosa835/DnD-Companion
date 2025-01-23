package dnd_companion.services;

import dnd_companion.entities.addons.components.Price;
import dnd_companion.entities.unit_related.currency.CurrencyUnitEntity;

public class CurrencyConverterService 
{
	public Price convert_to(Price price, CurrencyUnitEntity new_currency) {
		double conversion_factor = new_currency.normalizing_factor() / price.unit().normalizing_factor();
		double new_value = price.value() * conversion_factor;
		return new Price(new_value, new_currency);
	}
}
