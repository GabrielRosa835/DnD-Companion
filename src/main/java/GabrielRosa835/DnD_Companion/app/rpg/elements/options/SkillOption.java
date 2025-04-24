package app.rpg.elements.options;

import app.rpg.elements.models.Option;
import app.rpg.elements.options.abilityScores.*;

public record SkillOption(
		String name,
		AbilityScoreOption standardAbilityScore
) implements Option {
	//
}
