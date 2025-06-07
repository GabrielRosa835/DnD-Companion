package app.domain.effects;

import app.domain.elements.entities.*;

public interface ExtractedCharacterAttributes {

	static int initiative(PlayerCharacter character) {
		int dexValue = character.status().get("Dexterity").value();
		return AbilityScoreEffects.calculateModifier(dexValue);
	}
	static int armorClass (PlayerCharacter character) {
		return 0;
	}
	static int level (PlayerCharacter character) {
		return 0;
	}
	static int hitDiceTotal (PlayerCharacter character) {
		return 0;
	}
	static int hitDiceLeft (PlayerCharacter character) {
		return 0;
	}
	static int proficiencyBonus (PlayerCharacter character) {
		return 0;
	}
	static int attunementLimit (PlayerCharacter character) {
		return 0;
	}
}
