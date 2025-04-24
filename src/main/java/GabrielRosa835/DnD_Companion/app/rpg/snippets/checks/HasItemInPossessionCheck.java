package app.rpg.snippets.checks;

import app.rpg.elements.actors.CharacterActor;
import app.rpg.elements.compositions.ItemComposition;
import app.rpg.elements.models.types.Item;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HasItemInPossessionCheck
		implements Check {
	private ItemComposition belongings;
	private Item item;

	public static HasItemInPossessionCheck with(CharacterActor character, Item item) {
		var belongings = character.belongings();
		return new HasItemInPossessionCheck(belongings, item);
	}

	public static HasItemInPossessionCheck with(ItemComposition belongings, Item item) {
		return new HasItemInPossessionCheck(belongings, item);
	}

	@Override
	public boolean validate() {
		return belongings.content().containsKey(item);
	}
}
