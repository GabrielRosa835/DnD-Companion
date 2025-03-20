package elements.components.character;

import elements.entities.character.Character;
import elements.entities.items.Armor;
import elements.models.Item;
import lombok.*;
import lombok.experimental.*;
import tactics.*;

import java.util.*;

@RequiredArgsConstructor
@Builder (setterPrefix = "with")
@Accessors(fluent = true)
@ToString
@Getter

// Equipment
public class EquippedItems implements
		Effect.Applicable<EquippedItems>,
		Character.Property
{
	private final Character character;

	private List<Item> attunedMagicItems = new ArrayList<>();
	private Map<Integer, Item> heldItems = new HashMap<>();

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
