package elements.components.effective;

import elements.compositions.*;
import elements.entities.options.*;
import fundamentals.*;
import lombok.*;
import lombok.experimental.*;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@Builder
@Accessors(fluent = true)
public class EffectiveSkill
{
	private Skill type;
	private EffectiveAbilityScoreComposition abilityScoreComposition;
	private ProficiencyType proficiency;

	public int modifier() {
		EffectiveAbilityScore effectiveAbilityScore = abilityScoreComposition.get(type.standardAbilityScore());
		int proficiencyModifier = proficiency().proficiencyModifier(abilityScoreComposition.character());
		return effectiveAbilityScore.modifier() + proficiencyModifier;
	}
}
