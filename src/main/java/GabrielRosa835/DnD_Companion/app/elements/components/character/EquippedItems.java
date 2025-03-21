package GabrielRosa835.dnd_companion.app.elements.components.character;

import GabrielRosa835.dnd_companion.app.elements.entities.character.Character;
import GabrielRosa835.dnd_companion.app.elements.entities.items.*;
import GabrielRosa835.dnd_companion.app.elements.models.*;
import GabrielRosa835.dnd_companion.app.tactics.*;
import lombok.*;
import lombok.experimental.*;

import java.util.*;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@Accessors (fluent = true)
@ToString
@Builder (setterPrefix = "with")
@Getter

// Equipment
public class EquippedItems implements
		Effect.Applicable<EquippedItems>,
		Character.Property
{
	private Character character;

	@Singular("attuned")
	private List<Item> attunedMagicItems;
	@Singular("held")
	private Map<Integer, Item> heldItems;

	private Armor currentArmor;

	public EquippedItems setCurrentArmor(Armor armor) {
		this.currentArmor = (Armor) characterHasItem(armor);
		return this;
	}
	public EquippedItems setHeldItem(int handIndex, Item item) {
		this.heldItems.put(handIndex, characterHasItem(item));
		return this;
	}
	public EquippedItems attuneMagicItem(Item item) {
		int attunementLimit = character.keyProperties().attunementLimit();
		if (attunedMagicItems.size() > attunementLimit) {
			throw new UnsupportedOperationException("Maximum number of attuned items reached: " + attunementLimit);
		} else {
			attunedMagicItems.add(characterHasItem(item));
		}
		return this;
	}

	@Override public EquippedItems applyEffect(Effect<EquippedItems> effect) {
		var result = effect.applyTo(this);
		this.currentArmor = result.currentArmor;
		this.heldItems = result.heldItems;
		return this;
	}

	private Item characterHasItem(Item item) {
		if (character.belongings().contains(item)) {
			return character.belongings().get(item).type();
		} else {
			throw new IllegalArgumentException("The character has no such item: " + item.name());
		}
	}
}
