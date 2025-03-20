package elements.components.character;

import elements.entities.character.Character;
import lombok.*;
import lombok.experimental.*;
import tactics.*;

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

	private int attunementLimit = 3;
	private int proficiencyBonus = 2;

	@Override public CharacterKeyProperties applyEffect(Effect<CharacterKeyProperties> effect) {
		var result = effect.applyTo(this);
		this.attunementLimit = result.attunementLimit;
		this.proficiencyBonus = result.proficiencyBonus;
		return null;
	}
}
