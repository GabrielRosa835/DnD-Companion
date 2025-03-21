package GabrielRosa835.dnd_companion.app.elements.entities.character;

import GabrielRosa835.dnd_companion.app.elements.components.*;
import GabrielRosa835.dnd_companion.app.elements.components.character.*;
import GabrielRosa835.dnd_companion.app.elements.compositions.*;
import GabrielRosa835.dnd_companion.app.tactics.*;
import lombok.*;
import lombok.experimental.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor (access = AccessLevel.PACKAGE)
@Builder (setterPrefix = "with")
@Accessors(fluent = true)
@ToString
@Getter
public class Character implements
		Effect.Applicable<Character>
{
	private CharacterDecorationProperties decorationProperties;
	private CharacterClassComposition classes;
	private CharacterKeyProperties keyProperties;
	private AbilityScoreComposition status;
	private ItemSlotComposition belongings;
	private SkillSlotComposition skills;
	private EquippedItems equipment;
	private Health health;

	@Override
	public Character applyEffect (Effect<Character> effect) {
		Character result = effect.applyTo(this);
		return this;
	}

	public interface Property {
		Character character();
	}
}
