package dnd_companion.local_storage.data.structure.options;

import dnd_companion.local_storage.data.structure.templates.AtomicOption;

public record DiceType(String name, String abbreviation, int max_value) implements AtomicOption {
	public static final String GROUP = "dice-types";
	public String group() {return GROUP;}
}
