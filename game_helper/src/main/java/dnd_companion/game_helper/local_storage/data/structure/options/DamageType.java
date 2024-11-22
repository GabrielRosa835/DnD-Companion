package dnd_companion.game_helper.local_storage.data.structure.options;

public record DamageType(String damage_type_name) {
	public static final String OPTION_GROUP = "damage-types";
	public String option_group() {return OPTION_GROUP;}
}
