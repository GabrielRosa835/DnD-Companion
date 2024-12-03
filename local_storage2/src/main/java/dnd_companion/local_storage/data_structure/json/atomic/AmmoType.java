package dnd_companion.local_storage.data_structure.json.atomic;

import dnd_companion.local_storage.data_structure.json.templates.Item;

public record AmmoType(
	String name,
	double price_value,
	String price_unit,
	double weight_value,
	String weight_unit,
	String[] tags,
	String description
) implements Item {}
