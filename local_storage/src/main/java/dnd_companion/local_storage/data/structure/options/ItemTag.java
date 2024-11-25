package dnd_companion.local_storage.data.structure.options;

import dnd_companion.local_storage.data.structure.templates.AtomicOption;

public record ItemTag(String name) implements AtomicOption {
	public static final String GROUP = "item-tags";
	public String group() {return GROUP;}
}
