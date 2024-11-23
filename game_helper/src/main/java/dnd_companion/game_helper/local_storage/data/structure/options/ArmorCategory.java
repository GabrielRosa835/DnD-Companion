package dnd_companion.game_helper.local_storage.data.structure.options;

import dnd_companion.game_helper.local_storage.data.structure.templates.AtomicOption;

public record ArmorCategory(String name) implements AtomicOption {
	public static final String GROUP = "armor-categories";
	public String group() {return GROUP;}
}
