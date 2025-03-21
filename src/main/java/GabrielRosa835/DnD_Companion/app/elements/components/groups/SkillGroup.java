package GabrielRosa835.dnd_companion.app.elements.components.groups;


import GabrielRosa835.dnd_companion.app.common.*;
import GabrielRosa835.dnd_companion.app.elements.compositions.*;
import GabrielRosa835.dnd_companion.app.elements.entities.character.*;
import GabrielRosa835.dnd_companion.app.fundamentals.*;
import GabrielRosa835.dnd_companion.app.tactics.*;
import lombok.*;
import lombok.experimental.*;

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
