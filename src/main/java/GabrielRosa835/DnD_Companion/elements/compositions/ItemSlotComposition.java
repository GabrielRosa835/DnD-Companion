package elements.compositions;

import elements.components.slots.*;
import elements.entities.Character;
import elements.models.*;
import elements.models.types.*;
import lombok.*;
import lombok.experimental.*;
import tactics.*;

import java.util.*;

@RequiredArgsConstructor
@Builder (setterPrefix = "with")
@Accessors (fluent = true)
@ToString
@Getter

// Belongings
public class ItemSlotComposition implements
		Effect.Applicable<ItemSlotComposition>,
		Composition<Item, ItemSlot>,
		Character.Property
{
	private final Character character;

	@Singular("item")
	private Map<Item, ItemSlot> itemMapping = new HashMap<>();

	@Override public ItemSlot get(Item item) {
		return itemMapping.get(item);
	}
	@Override public ItemSlotComposition add(ItemSlot itemSlot) {
		itemMapping.put(itemSlot.type(), itemSlot);
		return this;
	}
	@Override public ItemSlotComposition remove(Item item) {
		itemMapping.remove(item);
		return this;
	}
	public boolean contains(Item item) {
		return itemMapping().containsKey(item);
	}
	public Collection<ItemSlot> content() {
		return itemMapping.values();
	}

	@Override public ItemSlotComposition applyEffect(Effect<ItemSlotComposition> effect) {
		var result = effect.applyTo(this);
		this.itemMapping = result.itemMapping;
		return this;
	}
}
