package dnd_companion.game_helper.local_storage.data.structure;

import dnd_companion.game_helper.local_storage.data.manipulation.atomic.price.Price;
import dnd_companion.game_helper.local_storage.data.manipulation.atomic.weight.Weight;

public record ArmorData(
	String name,
	String collection,
	Price price,
	Weight weight,
	String[] tags,
	String description,
	String category,
	int base_armor_class,
	int strength_requirement,
	boolean stealth_disavantage
) implements ItemData {}

