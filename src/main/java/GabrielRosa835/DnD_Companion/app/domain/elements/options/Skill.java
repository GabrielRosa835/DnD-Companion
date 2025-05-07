package app.domain.elements.options;

import app.domain.elements.models.Option;
import app.storage.reference.*;

public record Skill(
		String ID,
		String name,
		@AsReference AbilityScoreType standardAbilityScore
) implements Option {

}
