package tactics.operations.ability_score;

import elements.components.effective.*;
import elements.compositions.*;
import elements.entities.options.*;
import fundamentals.*;
import lombok.*;
import tactics.*;

@AllArgsConstructor
public class RollAbilityScoreTest implements Operation<Integer>
{
	private EffectiveAbilityScoreComposition composition;
	private AbilityScore abilityScore;

	public Integer execute() {
		EffectiveAbilityScore effectiveAbilityScore = composition.get(abilityScore);
		return Dice.D20.roll() + effectiveAbilityScore.modifier();
	}
}
