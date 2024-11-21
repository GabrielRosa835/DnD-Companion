package dnd_companion.game_helper.local_storage.data.structure;

public record ArmorData(
	String name,
	String collection,
	double normalized_price,
	double normalized_weight,
	String[] tags,
	String description,
	String category,
	int base_armor_class,
	int strength_requirement,
	boolean stealth_disavantage
) implements ItemData {}

