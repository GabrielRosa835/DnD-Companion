package GabrielRosa835.models.types;

import GabrielRosa835.components.*;

public interface Item {
	String name();

	Measure.Price price();

	Measure.Weight weight();

	Tag[] tags();

	String description();

	enum Tag {
		ADVENTURING_GEAR, AMMUNITION, ARMOR, FOOD_AND_DRINK, INSTRUMENT, MAGICAL, TOOL, WEAPON
	}
}