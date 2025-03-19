package tactics.operations.skill;

import elements.components.slots.*;
import elements.compositions.*;
import elements.entities.options.*;
import fundamentals.*;
import lombok.*;
import tactics.*;

@NoArgsConstructor (access = AccessLevel.PUBLIC, staticName = "use")
@AllArgsConstructor (access = AccessLevel.PRIVATE)
@With
public class RollSkillTestWithDifferentAbilityScore implements Operation<Integer>
{
	private SkillSlot skillSlot;
	private AbilityScore abilityScore;

	public static RollSkillTestWithDifferentAbilityScore use() {
		return new RollSkillTestWithDifferentAbilityScore();
	}

	public Integer execute() {
		AbilityScoreSlotComposition composition = skillSlot.abilityScoreSlotComposition();
		int abilityScoreModifier = composition.get(abilityScore).modifier();
		int proficiencyModifier = skillSlot.proficiency().proficiencyModifier(composition.character());
		return Dice.D20.roll() + abilityScoreModifier + proficiencyModifier;
	}
}
