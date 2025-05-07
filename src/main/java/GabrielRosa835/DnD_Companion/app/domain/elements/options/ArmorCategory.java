package app.domain.elements.options;

import app.domain.elements.models.Option;

public record ArmorCategory(
		String ID,
		String name
) implements Option {
	// UNARMORED, LIGHT, MEDIUM, HEAVY, SHIELD
}
