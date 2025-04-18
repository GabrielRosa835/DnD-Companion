package app.rpg.elements.components;

import app.rpg.strategies.checks.HasItemCheck;
import app.rpg.elements.actors.CharacterActor;
import app.rpg.models.Component;
import app.rpg.elements.options.ArmorOption;
import app.rpg.elements.options.types.Item;
import lombok.*;
import lombok.experimental.*;

import java.util.*;

@Builder (setterPrefix = "with")
@Accessors(fluent = true)
@ToString
@Getter
public class EquipmentComponent
	implements Component<EquipmentComponent>
{
	private CharacterActor character;

	@Singular ("attunedMagicItem")
	private List<Item> attunedMagicItems = new ArrayList<>();
	@Singular ("heldItem")
	private Map<Integer, Item> heldItems = new HashMap<>();
	private ArmorOption currentArmorOption;

	public EquipmentComponent setCurrentArmor(ArmorOption armorOption, CharacterActor character) {
		this.character = character;
		if (HasItemCheck.with(character, armorOption))
			this.currentArmorOption = armorOption;
		return this;
	}
	public EquipmentComponent setHeldItem(int handIndex, Item item, CharacterActor character) {
		this.character = character;
		if (HasItemCheck.with(character, item))
			this.heldItems.put(handIndex, item);
		return this;
	}
	public EquipmentComponent attuneMagicItem(Item item, int attunementLimit, CharacterActor character) {
		this.character = character;
		if (attunedMagicItems.size() < attunementLimit && HasItemCheck.with(character, item)) {
			attunedMagicItems.add(item);
		}
		return this;
	}

	@Override public void update (EquipmentComponent clone) {

	}
}
