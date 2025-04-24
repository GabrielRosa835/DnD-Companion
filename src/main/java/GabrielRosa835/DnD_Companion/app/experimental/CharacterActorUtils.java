package app.experimental;

import app.rpg.elements.actors.*;
import app.rpg.elements.options.abilityScores.*;

public class CharacterActorUtils {

	public static int getAbilityScoreModifier (CharacterActor character, AbilityScoreOption option) {
		int value = character.status().content().get(option).value();
		return (int) Math.floor(value / 3.0) - 5;
	}

}
