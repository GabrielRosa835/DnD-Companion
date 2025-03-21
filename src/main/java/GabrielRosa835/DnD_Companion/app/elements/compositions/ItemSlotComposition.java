package GabrielRosa835.dnd_companion.app.elements.compositions;

import GabrielRosa835.dnd_companion.app.elements.components.groups.*;
import GabrielRosa835.dnd_companion.app.elements.entities.character.Character;
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

// Belongings
public class ItemSlotComposition implements
		Effect.Applicable<ItemSlotComposition>,
		Composition<Item, ItemGroup>,
		Character.Property
{
	private Character character;

	@Singular("item")
	private Map<Item, ItemGroup> itemMapping;

	@Override public ItemGroup get(Item item) {
		return itemMapping.get(item);
	}
	@Override public ItemSlotComposition add(ItemGroup itemGroup) {
		itemMapping.put(itemGroup.type(), itemGroup);
		return this;
	}
	@Override public ItemSlotComposition remove(Item item) {
		itemMapping.remove(item);
		return this;
	}
	public boolean contains(Item item) {
		return itemMapping().containsKey(item);
	}
	public Collection<ItemGroup> content() {
		return itemMapping.values();
	}

	@Override public ItemSlotComposition applyEffect(Effect<ItemSlotComposition> effect) {
		var result = effect.applyTo(this);
		this.itemMapping = result.itemMapping;
		return this;
	}
}
