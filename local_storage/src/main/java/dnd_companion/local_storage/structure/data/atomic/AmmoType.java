package dnd_companion.local_storage.structure.data.atomic;

import dnd_companion.local_storage.structure.data.templates.Item;

public record AmmoType(
	String name,
	double price_value,
	String price_unit,
	double weight_value,
	String weight_unit,
	String[] tags,
	String description
) implements Item {}
