package app.rpg.elements.options;

import app.rpg.models.Option;

public record SkillOption (
		String name,
		AbilityScoreOption standardAbilityScore
) implements Option
{
	//
}
