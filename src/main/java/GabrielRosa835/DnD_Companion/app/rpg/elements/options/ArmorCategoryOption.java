package app.rpg.elements.options;

import app.rpg.models.Option;

public record ArmorCategoryOption (
		String name
) implements Option
{
	// UNARMORED, LIGHT, MEDIUM, HEAVY
}
