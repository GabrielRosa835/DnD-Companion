package app.rpg.elements.options.abilityScores;

import app.rpg.elements.models.Option;

import java.util.*;

public record AbilityScoreOption(
		String name
) implements Option {
	public static final Set<AbilityScoreOption> fixed = Set.of(
			ABILITY_SCORE_STRENGTH.use,
			ABILITY_SCORE_DEXTERITY.use,
			ABILITY_SCORE_CONSTITUTION.use,
			ABILITY_SCORE_INTELLIGENCE.use,
			ABILITY_SCORE_WISDOM.use,
			ABILITY_SCORE_CHARISMA.use
	);
}
