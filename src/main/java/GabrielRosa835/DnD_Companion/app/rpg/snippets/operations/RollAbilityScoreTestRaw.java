package app.rpg.snippets.operations;

import app.rpg.elements.actors.*;
import app.rpg.elements.components.*;
import app.rpg.elements.compositions.*;
import app.rpg.elements.options.abilityScores.*;
import app.rpg.elements.options.dices.*;
import lombok.*;

@AllArgsConstructor
public class RollAbilityScoreTestRaw
{
	public static int with(CharacterActor character, AbilityScoreOption option) {
		int abilityScoreValue = character.status().content().get(option).value();
		int modifier = new CalculateAbilityScoreModifier(abilityScoreValue).process();
		return DICE_D20.use.roll() + modifier;
	}

	public static int with(AbilityScoreComposition composition, AbilityScoreOption option) {
		int abilityScoreValue = composition.content().get(option).value();
		int modifier = new CalculateAbilityScoreModifier(abilityScoreValue).process();
		return DICE_D20.use.roll() + modifier;
	}

	public static int with(AbilityScoreComponent abilityScore) {
		int abilityScoreValue = abilityScore.value();
		int modifier = new CalculateAbilityScoreModifier(abilityScoreValue).process();
		return DICE_D20.use.roll() + modifier;
	}

	public static int withValue(int abilityScoreValue) {
		int modifier = new CalculateAbilityScoreModifier(abilityScoreValue).process();
		return DICE_D20.use.roll() + modifier;
	}
}
