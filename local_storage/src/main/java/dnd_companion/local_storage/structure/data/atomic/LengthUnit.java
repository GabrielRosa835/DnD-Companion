package dnd_companion.local_storage.structure.data.atomic;

import dnd_companion.local_storage.structure.data.templates.AtomicUnit;

public record LengthUnit(String name, String abbreviation, double normalizing_factor)
implements AtomicUnit
{
	public LengthUnit {
		abbreviation = abbreviation.toUpperCase();
	}
}
