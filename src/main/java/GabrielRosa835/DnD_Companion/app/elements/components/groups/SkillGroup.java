package elements.components.groups;

import common.*;
import elements.compositions.*;
import elements.entities.character.Skill;
import fundamentals.*;
import lombok.*;
import lombok.experimental.*;
import behaviors.*;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@NoArgsConstructor (access = AccessLevel.PACKAGE)
@Builder (setterPrefix = "with")
@Accessors (fluent = true)
@ToString
@Getter
public class SkillGroup implements
		Effect.Applicable<SkillGroup>,
		Replicable
{
	private AbilityScoreComposition abilityScoreComposition;
	private ProficiencyType proficiency;
	private Skill type;

	public int modifier() {
		AbilityScoreGroup abilityScoreGroup = abilityScoreComposition.get(type.standardAbilityScore());
		int proficiencyModifier = proficiency().proficiencyModifier(abilityScoreComposition.character());
		return abilityScoreGroup.modifier() + proficiencyModifier;
	}

	@Override
	public SkillGroup applyEffect(Effect<SkillGroup> effect) {
		var result = effect.applyTo(this);
		this.abilityScoreComposition = result.abilityScoreComposition;
		this.proficiency = result.proficiency;
		this.type = result.type;
		return this;
	}
}
