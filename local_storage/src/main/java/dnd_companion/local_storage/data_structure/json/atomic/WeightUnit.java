package dnd_companion.local_storage.data_structure.json.atomic;

import dnd_companion.local_storage.data_structure.json.templates.AtomicUnit;

public record WeightUnit(String name, String abbreviation, double normalizing_factor)
implements AtomicUnit
{
	public WeightUnit {
		abbreviation = abbreviation.toUpperCase();
	}
}
