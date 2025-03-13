package elements.components.effective;

import common.*;
import elements.compositions.*;
import elements.entities.options.*;
import fundamentals.*;
import lombok.*;
import lombok.experimental.*;
import tactics.*;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@NoArgsConstructor (access = AccessLevel.PACKAGE)
@Builder (setterPrefix = "with")
@Accessors (fluent = true)
@ToString
@Getter
public class EffectiveSkill implements
		Effect.Applicable<EffectiveSkill>,
		Replicable
{
	private EffectiveAbilityScoreComposition abilityScoreComposition;
	private ProficiencyType proficiency;
	private Skill type;

	public int modifier() {
		EffectiveAbilityScore effectiveAbilityScore = abilityScoreComposition.get(type.standardAbilityScore());
		int proficiencyModifier = proficiency().proficiencyModifier(abilityScoreComposition.character());
		return effectiveAbilityScore.modifier() + proficiencyModifier;
	}

	@Override
	public EffectiveSkill applyEffect(Effect<EffectiveSkill> effect) {
		var result = effect.applyTo(this);
		this.abilityScoreComposition = result.abilityScoreComposition;
		this.proficiency = result.proficiency;
		this.type = result.type;
		return this;
	}
}
