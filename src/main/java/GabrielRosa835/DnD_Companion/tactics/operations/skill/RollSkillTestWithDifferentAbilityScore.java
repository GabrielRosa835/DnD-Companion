package tactics.operations.skill;

import elements.components.groups.*;
import elements.compositions.*;
import elements.entities.character.AbilityScore;
import fundamentals.*;
import lombok.*;
import tactics.*;

@NoArgsConstructor (access = AccessLevel.PUBLIC, staticName = "use")
@AllArgsConstructor (access = AccessLevel.PRIVATE)
@With
public class RollSkillTestWithDifferentAbilityScore implements Operation<Integer>
{
	private SkillGroup skillGroup;
	private AbilityScore abilityScore;

	public static RollSkillTestWithDifferentAbilityScore use() {
		return new RollSkillTestWithDifferentAbilityScore();
	}

	public Integer execute() {
		AbilityScoreComposition composition = skillGroup.abilityScoreComposition();
		int abilityScoreModifier = composition.get(abilityScore).modifier();
		int proficiencyModifier = skillGroup.proficiency().proficiencyModifier(composition.character());
		return Dice.D20.roll() + abilityScoreModifier + proficiencyModifier;
	}
}
