package dnd_companion.local_storage.structure.data.atomic;

import dnd_companion.local_storage.structure.data.templates.AtomicUnit;

public record CurrencyUnit(String name, String abbreviation, double normalizing_factor)
implements AtomicUnit
{
	public CurrencyUnit {
		abbreviation = abbreviation.toUpperCase();
	}
}
