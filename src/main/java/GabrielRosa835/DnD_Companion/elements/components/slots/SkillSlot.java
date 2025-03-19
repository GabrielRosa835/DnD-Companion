package elements.components.slots;

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
public class SkillSlot implements
		Effect.Applicable<SkillSlot>,
		Replicable
{
	private AbilityScoreSlotComposition abilityScoreSlotComposition;
	private ProficiencyType proficiency;
	private Skill type;

	public int modifier() {
		AbilityScoreSlot abilityScoreSlot = abilityScoreSlotComposition.get(type.standardAbilityScore());
		int proficiencyModifier = proficiency().proficiencyModifier(abilityScoreSlotComposition.character());
		return abilityScoreSlot.modifier() + proficiencyModifier;
	}

	@Override
	public SkillSlot applyEffect(Effect<SkillSlot> effect) {
		var result = effect.applyTo(this);
		this.abilityScoreSlotComposition = result.abilityScoreSlotComposition;
		this.proficiency = result.proficiency;
		this.type = result.type;
		return this;
	}
}
