package dnd_companion.local_storage.data.structure;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import dnd_companion.local_storage.data.manipulation.ItemTags;
import dnd_companion.local_storage.data.manipulation.price.Price;
import dnd_companion.local_storage.data.manipulation.weight.Weight;
import dnd_companion.local_storage.data.structure.options.ArmorCategory;
import dnd_companion.local_storage.data.structure.templates.ItemData;

public record ArmorData(
	String name,
	Price price,
	Weight weight,
	ItemTags tags,
	String description,
	ArmorCategory category,
	int base_armor_class,
	int strength_requirement,
	boolean stealth_disadvantage
) implements ItemData {
	public static final String COLLECTION = "armors";
	@JsonProperty("collection") public String collection() {return COLLECTION;}
	
	@JsonCreator
    public ArmorData(
        @JsonProperty("name") String name,
        @JsonProperty("price") Price price,
        @JsonProperty("weight") Weight weight,
        @JsonProperty("tags") ItemTags tags,
        @JsonProperty("description") String description,
        @JsonProperty("category") ArmorCategory category,
        @JsonProperty("base_armor_class") int baseArmorClass,
        @JsonProperty("strength_requirement") int strengthRequirement,
        @JsonProperty("stealth_disadvantage") boolean stealthDisadvantage,
        @JsonProperty("collection") String collection
    ) {
        this(name, price, weight, tags, description, category, baseArmorClass, strengthRequirement, stealthDisadvantage);
    }
}

