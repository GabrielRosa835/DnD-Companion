package dnd_companion.game_helper.local_storage.data.structure.options;

import dnd_companion.game_helper.local_storage.data.structure.templates.AtomicOptionUnit;

public record WeightUnit(String name, String abbreviation, double normalizing_factor) implements AtomicOptionUnit {
	public static final String GROUP = "weight-units";
	public String group() {return GROUP;}
}
