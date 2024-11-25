package dnd_companion.local_storage.data.structure.options;

import dnd_companion.local_storage.data.structure.templates.AtomicOption;

public record DamageType(String name) implements AtomicOption {
	public static final String GROUP = "damage-types";
	public String group() {return GROUP;}
}
