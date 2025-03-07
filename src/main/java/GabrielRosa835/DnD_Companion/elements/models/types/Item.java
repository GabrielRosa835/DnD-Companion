package elements.models.types;

import elements.components.*;

import java.util.*;

public interface Item {
	String name();
	Measure.Price price();
	Measure.Weight weight();
	Tag[] tags();
	String description();

	enum Tag {
		ADVENTURING_GEAR, AMMUNITION, ARMOR, FOOD_AND_DRINK, INSTRUMENT, MAGICAL, TOOL, WEAPON
	}
	interface Effect extends tactics.Effect {
		String changeName();
		Measure.Price changePrice();
		Measure.Weight changeWeight();
		String changeDescription();
		List<Tag> changeTags();
	}
}