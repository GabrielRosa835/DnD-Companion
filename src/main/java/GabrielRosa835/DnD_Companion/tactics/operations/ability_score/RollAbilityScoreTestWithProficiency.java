package tactics.operations.ability_score;

import elements.components.groups.*;
import elements.compositions.*;
import elements.entities.character.AbilityScore;
import fundamentals.*;
import lombok.*;
import tactics.*;

@NoArgsConstructor (access = AccessLevel.PUBLIC, staticName = "use")
@AllArgsConstructor (access = AccessLevel.PRIVATE)
@With
public class RollAbilityScoreTestWithProficiency implements Operation<Integer>
{
	private AbilityScoreComposition composition;
	private AbilityScore abilityScore;

	public Integer execute() {
		AbilityScoreGroup abilityScoreGroup = composition.get(abilityScore);
		int proficiencyBonus = composition.character().proficiencyBonus();
		int proficiencyModifier = (int) (proficiencyBonus * abilityScoreGroup.savingThrowProficiency().multiplier());
		return Dice.D20.roll() + abilityScoreGroup.modifier() + proficiencyModifier;
	}
}
