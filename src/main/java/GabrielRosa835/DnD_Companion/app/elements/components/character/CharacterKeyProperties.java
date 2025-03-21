package GabrielRosa835.dnd_companion.app.elements.components.character;

import GabrielRosa835.dnd_companion.app.elements.entities.character.Character;
import GabrielRosa835.dnd_companion.app.tactics.*;
import lombok.*;
import lombok.experimental.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder (setterPrefix = "with")
@Accessors (fluent = true)
@ToString
@Getter
public class CharacterKeyProperties implements
		Effect.Applicable<CharacterKeyProperties>,
		Character.Property
{
	private final Character character;

	@Builder.Default
	private int attunementLimit = 3;

	@Builder.Default
	private int proficiencyBonus = 2;

	@Override public CharacterKeyProperties applyEffect(Effect<CharacterKeyProperties> effect) {
		var result = effect.applyTo(this);
		this.attunementLimit = result.attunementLimit;
		this.proficiencyBonus = result.proficiencyBonus;
		return null;
	}
}
