package app.rpg.snippets.checks;

import app.rpg.elements.actors.*;
import app.rpg.elements.models.types.*;
import co.unruly.control.result.*;

public interface Checks {

	static boolean characterPossessItem(CharacterActor character, Item item) {
		return character.inventory().content().containsKey(item);
	}
	static boolean characterHasItemOnHandCheck(CharacterActor character, Item item) {
		return character.equipment().heldItems().containsValue(item);
	}

}
