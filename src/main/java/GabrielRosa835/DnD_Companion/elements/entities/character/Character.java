package elements.entities.character;

import elements.components.*;
import elements.components.character.*;
import elements.compositions.*;
import lombok.*;
import lombok.experimental.*;
import tactics.Effect;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@NoArgsConstructor (access = AccessLevel.PACKAGE)
@Builder (setterPrefix = "with")
@Accessors (fluent = true)
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
