package dnd_companion.local_storage.data_structure.json.atomic;

import dnd_companion.local_storage.data_structure.json.templates.AtomicUnit;

public record LengthUnit(String name, String abbreviation, double normalizing_factor)
implements AtomicUnit
{
	public LengthUnit {
		abbreviation = abbreviation.toUpperCase();
	}
}
