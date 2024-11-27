package dnd_companion.local_storage.data.structure.atomic;

import dnd_companion.local_storage.data.structure.templates.AtomicUnit;
import dnd_companion.local_storage.system_components.utils.ToolBox;

public record WeightUnit(String name, String abbreviation, double normalizing_factor) 
implements AtomicUnit 
{
	public WeightUnit {
		name = ToolBox.to_snake_case(name);
		abbreviation = abbreviation.toUpperCase();
	}
}
