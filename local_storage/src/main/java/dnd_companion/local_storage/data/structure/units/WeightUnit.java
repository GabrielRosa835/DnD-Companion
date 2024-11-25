package dnd_companion.local_storage.data.structure.units;

import dnd_companion.local_storage.data.structure.templates.AtomicUnit;

public record WeightUnit(String name, String abbreviation, double normalizing_factor) implements AtomicUnit {
	public static final String GROUP = "weight-units";
	public String group() {return GROUP;}
}
