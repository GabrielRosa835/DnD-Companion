package elements.components.groups;

import common.*;
import elements.entities.character.CharacterClass;
import lombok.*;
import lombok.experimental.*;
import behaviors.*;

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