package elements.compositions;

import elements.components.groups.*;
import elements.entities.character.Character;
import elements.models.*;
import lombok.*;
import lombok.experimental.*;
import behaviors.*;

import java.util.*;

@RequiredArgsConstructor
@Builder (setterPrefix = "with")
@Accessors (fluent = true)
@ToString
@Getter

// Belongings
public class ItemSlotComposition implements
		Effect.Applicable<ItemSlotComposition>,
		Composition<Item, ItemGroup>,
		Character.Property
{
	private final Character character;

	@Singular("item")
	private Map<Item, ItemGroup> itemMapping = new HashMap<>();

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
