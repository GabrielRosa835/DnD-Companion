package GabrielRosa835.dnd_companion.app.elements.components.groups;


import GabrielRosa835.dnd_companion.app.common.*;
import GabrielRosa835.dnd_companion.app.elements.entities.character.*;
import GabrielRosa835.dnd_companion.app.tactics.*;
import lombok.*;
import lombok.experimental.*;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@NoArgsConstructor (access = AccessLevel.PACKAGE)
@Accessors (fluent = true)
@ToString
@Builder (setterPrefix = "with")
@Getter
public class CharacterClassGroup implements
		Effect.Applicable<CharacterClassGroup>,
		Replicable
{
	private CharacterClass type;
	private int level;

	@Override
	public CharacterClassGroup applyEffect(Effect<CharacterClassGroup> effect) {
		var result = effect.applyTo(this);
		this.type = result.type;
		this.level = result.level;
		return this;
	}
}