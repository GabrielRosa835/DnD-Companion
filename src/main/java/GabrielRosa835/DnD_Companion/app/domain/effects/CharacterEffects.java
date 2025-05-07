package app.domain.effects;

import app.domain.elements.entities.*;
import app.domain.elements.models.types.*;

public interface CharacterEffects {

	static boolean characterPossessItem(PlayerCharacter character, Item item) {
		return character.inventory().containsKey(item);
	}
	static boolean characterHasItemOnHandCheck(PlayerCharacter character, Item item) {
		return character.equipment().heldItems().containsValue(item);
	}
	static boolean hasItemInPossessionCheck(PlayerCharacter character, Item item) {
		return character.inventory().containsKey(item);
	}

}
