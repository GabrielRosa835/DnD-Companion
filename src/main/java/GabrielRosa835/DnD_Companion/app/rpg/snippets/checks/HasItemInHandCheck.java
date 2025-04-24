package app.rpg.snippets.checks;

import app.common.functions.*;
import app.rpg.elements.actors.*;
import app.rpg.elements.components.*;
import app.rpg.elements.models.types.*;
import app.strategies.models.*;
import lombok.*;

@AllArgsConstructor
public class HasItemInHandCheck
	implements Check
{
	private EquipmentComponent equipment;
	private Item item;

	public static HasItemInHandCheck with (CharacterActor character, Item item) {
		var equipment = character.equipment();
		return new HasItemInHandCheck(equipment, item);
	}
	public static HasItemInHandCheck with (EquipmentComponent equipment, Item item) {
		return new HasItemInHandCheck(equipment, item);
	}

	@Override public boolean validate() {
		return equipment.heldItems().containsValue(item);
	}
}
