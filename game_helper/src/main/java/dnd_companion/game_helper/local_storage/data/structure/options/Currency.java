package dnd_companion.game_helper.local_storage.data.structure.options;

import dnd_companion.game_helper.local_storage.data.structure.templates.AtomicOptionUnit;

public record Currency(String name, String abbreviation, double normalizing_factor) implements AtomicOptionUnit {
	public static final String OPTION_GROUP = "currencies";
	public String group() {return OPTION_GROUP;}
}
