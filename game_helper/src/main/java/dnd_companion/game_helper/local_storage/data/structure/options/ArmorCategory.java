package dnd_companion.game_helper.local_storage.data.structure.options;

import dnd_companion.game_helper.local_storage.data.structure.templates.AtomicOption;

public record ArmorCategory(String name) implements AtomicOption {
	public static final String OPTION_GROUP = "armor-categories";
	public String group() {return OPTION_GROUP;}
}
