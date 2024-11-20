package dnd_companion.game_helper.local_storage.data_structure.data;

import dnd_companion.game_helper.local_storage.Data;
import dnd_companion.game_helper.local_storage.data_structure.options.ItemBasicProperties;

public record ArmorData(
	String collection,
	String name,
	ItemBasicProperties basic_properties,
	String category,
	int base_armor_class,
	int strength_requirement,
	boolean stealth_disavantage
) implements Data {}

