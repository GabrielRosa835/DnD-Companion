package tactics.operations.ability_score;

import elements.components.groups.*;
import elements.compositions.*;
import elements.entities.character.AbilityScore;
import elements.entities.character.Character;
import fundamentals.*;
import lombok.*;
import tactics.*;

@AllArgsConstructor
public class RollAbilityScoreTest implements Operation<Integer>
{
	private int abilityScoreModifier;

	public static int with(int abilityScoreModifier) {
		return new RollAbilityScoreTest(abilityScoreModifier).execute();
	}
	public static int with(AbilityScoreGroup abilityScoreGroup) {
		int abilityScoreModifier = abilityScoreGroup.modifier();
		return new RollAbilityScoreTest(abilityScoreModifier).execute();
	}
	public static int with(AbilityScoreComposition composition, AbilityScore abilityScore) {
		int abilityScoreModifier = composition.get(abilityScore).modifier();
		return new RollAbilityScoreTest(abilityScoreModifier).execute();
	}
	public static int with(Character character, AbilityScore abilityScore) {
		int abilityScoreModifier = character.status().get(abilityScore).modifier();
		return new RollAbilityScoreTest(abilityScoreModifier).execute();
	}

	public Integer execute() {
		return Dice.D20.roll() + abilityScoreModifier;
	}
}
