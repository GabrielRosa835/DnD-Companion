package app.rpg.elements.options;

import app.rpg.elements.models.Option;

public record UnitTypeOption(
		String name
) implements Option {
	// DISTANCE, WEIGHT, TIME, CURRENCY
}
