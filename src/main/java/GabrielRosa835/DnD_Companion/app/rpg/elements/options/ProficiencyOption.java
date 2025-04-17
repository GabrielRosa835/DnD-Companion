package app.rpg.elements.options;

import app.rpg.models.Option;

public record ProficiencyOption(
		String name,
		double multiplier
) implements Option
{
	// NONE(0), HALF(0.5), NORMAL(1), EXPERTISE(2);
}
