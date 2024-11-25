package dnd_companion.local_storage.data.structure.units;

import dnd_companion.local_storage.data.structure.templates.AtomicUnit;

public record Currency(String name, String abbreviation, double normalizing_factor) implements AtomicUnit {
	public static final String GROUP = "currencies";
	public String group() {return GROUP;}
}
