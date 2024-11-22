package dnd_companion.game_helper.local_storage.data.structure;

import com.fasterxml.jackson.annotation.JsonProperty;

import dnd_companion.game_helper.local_storage.data.manipulation.atomic.price.Price;
import dnd_companion.game_helper.local_storage.data.manipulation.atomic.weight.Weight;
import dnd_companion.game_helper.local_storage.data.structure.options.ArmorCategory;
import dnd_companion.game_helper.local_storage.data.structure.templates.ItemData;

public record ArmorData(
	String name,
	Price price,
	Weight weight,
	String[] tags,
	String description,
	ArmorCategory category,
	int base_armor_class,
	int strength_requirement,
	boolean stealth_disavantage
) implements ItemData {
	public static final String COLLECTION = "armors";
	@JsonProperty("collection") public String collection() {return COLLECTION;}
}

