package app.domain.effects;

import app.domain.elements.entities.*;
import app.domain.elements.variants.*;

public interface CharacterEffects {

	static boolean characterPossessItem(PlayerCharacter character, IsItem isItem) {
		return character.inventory().containsKey(isItem);
	}
	static boolean characterHasItemOnHandCheck(PlayerCharacter character, IsItem isItem) {
		return character.equipment().heldItems().containsValue(isItem);
	}
	static boolean hasItemInPossessionCheck(PlayerCharacter character, IsItem isItem) {
		return character.inventory().containsKey(isItem);
	}

}
