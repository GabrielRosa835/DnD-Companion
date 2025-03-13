package tactics.operations.skill;

import elements.components.effective.*;
import elements.compositions.*;
import elements.entities.Character;
import elements.entities.options.*;
import fundamentals.*;
import lombok.*;
import tactics.*;

@AllArgsConstructor
public class RollSkillTestWithDifferentAbilityScore implements Operation<Integer>
{
	private EffectiveSkill effectiveSkill;
	private AbilityScore abilityScore;

	public Integer execute() {
		EffectiveAbilityScoreComposition composition = effectiveSkill.abilityScoreComposition();
		int abilityScoreModifier = composition.get(abilityScore).modifier();
		int proficiencyModifier = effectiveSkill.proficiency().proficiencyModifier(composition.character());
		return Dice.D20.roll() + abilityScoreModifier + proficiencyModifier;
	}
}
