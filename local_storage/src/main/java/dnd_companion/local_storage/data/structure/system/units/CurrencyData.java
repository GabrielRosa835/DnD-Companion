package dnd_companion.local_storage.data.structure.system.units;

import dnd_companion.local_storage.data.structure.atomic.Currency;
import dnd_companion.local_storage.data.structure.templates.OptionData;

public record CurrencyData (Currency... options)
implements OptionData<Currency> 
{
	public String collection() {return "system";}
	public String name() {return "currencies";}
}
