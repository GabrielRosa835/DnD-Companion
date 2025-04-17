package app.rpg.elements.components;

import app.rpg.elements.compositions.AbilityScoreComposition;
import app.rpg.models.Component;
import app.rpg.elements.options.ProficiencyOption;
import app.rpg.elements.options.SkillOption;
import lombok.*;
import lombok.experimental.Accessors;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@Accessors (fluent = true)
@ToString
@Builder (setterPrefix = "with")
@Getter
public class SkillComponent
	implements Component<SkillComponent>
{
	private AbilityScoreComposition abilityScores;
	private ProficiencyOption proficiency;
	private SkillOption type;

	@Override public void update (SkillComponent clone) {
		this.abilityScores.update(clone.abilityScores);
		this.proficiency = clone.proficiency;
		this.type = clone.type;
	}
}
