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
public class RollAbilityScoreTest implements Operation<Integer>
{
	private EffectiveAbilityScoreComposition composition = null;
	private AbilityScore abilityScore = null;

	public static RollAbilityScoreTest use() {
		return new RollAbilityScoreTest();
	}

	public Integer execute() {
		EffectiveAbilityScore effectiveAbilityScore = composition.get(abilityScore);
		return Dice.D20.roll() + effectiveAbilityScore.modifier();
	}
}
