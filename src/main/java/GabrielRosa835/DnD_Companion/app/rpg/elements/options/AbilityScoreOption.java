package app.rpg.elements.options;

import app.rpg.models.Option;

public record AbilityScoreOption (
		String name
) implements Option
{
	// STRENGTH, DEXTERITY, CONSTITUTION, INTELLIGENCE, WISDOM, CHARISMA
}
