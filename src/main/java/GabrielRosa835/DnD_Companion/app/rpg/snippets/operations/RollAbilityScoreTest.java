package app.rpg.snippets.operations;

import app.rpg.elements.actors.CharacterActor;
import app.rpg.elements.components.AbilityScoreComponent;
import app.rpg.elements.compositions.*;
import app.rpg.elements.options.abilityScores.AbilityScoreOption;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RollAbilityScoreTest
{
	private final int modifier;

	public static RollAbilityScoreTest with(CharacterActor character, AbilityScoreOption option) {

		return new RollAbilityScoreTest(modifier);
	}

	public static RollAbilityScoreTest with(AbilityScoreComposition composition, AbilityScoreOption option) {
		int abilityScoreValue = composition.content().get(option).value();
		int modifier = new CalculateAbilityScoreModifier(abilityScoreValue).process();
		return new RollAbilityScoreTest(modifier);
	}

	public static RollAbilityScoreTest with(AbilityScoreComponent abilityScore) {
		int abilityScoreValue = abilityScore.value();
		int modifier = new CalculateAbilityScoreModifier(abilityScoreValue).process();
		return new RollAbilityScoreTest(modifier);
	}

	public static RollAbilityScoreTest withValue(int abilityScoreValue) {
		int modifier = new CalculateAbilityScoreModifier(abilityScoreValue).process();
		return new RollAbilityScoreTest(modifier);
	}

	public static RollAbilityScoreTest with(int modifier) {
		return new RollAbilityScoreTest(modifier);
	}

	@Override
	public Integer process() {
		int D20Roll = RollDiceOperation.with("D20").process();
		return D20Roll + modifier;
	}
}
