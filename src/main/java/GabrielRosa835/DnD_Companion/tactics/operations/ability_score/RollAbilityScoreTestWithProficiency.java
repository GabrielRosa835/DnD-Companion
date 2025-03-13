package tactics.operations.ability_score;

import elements.components.effective.*;
import elements.compositions.*;
import elements.entities.options.*;
import fundamentals.*;
import lombok.*;
import tactics.*;

@NoArgsConstructor (access = AccessLevel.PUBLIC, staticName = "use")
@AllArgsConstructor (access = AccessLevel.PRIVATE)
@With
public class RollAbilityScoreTestWithProficiency implements Operation<Integer>
{
	private EffectiveAbilityScoreComposition composition;
	private AbilityScore abilityScore;

	public Integer execute() {
		EffectiveAbilityScore effectiveAbilityScore = composition.get(abilityScore);
		int proficiencyBonus = composition.character().proficiencyBonus();
		int proficiencyModifier = (int) (proficiencyBonus * effectiveAbilityScore.proficiencySavingThrow().multiplier());
		return Dice.D20.roll() + effectiveAbilityScore.modifier() + proficiencyModifier;
	}
}
