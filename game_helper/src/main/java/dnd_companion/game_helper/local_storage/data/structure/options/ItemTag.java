package dnd_companion.game_helper.local_storage.data.structure.options;

public record ItemTag(String name) {
	public static final String OPTION_GROUP = "item-tags";
	public String option_group() {return OPTION_GROUP;}
}
