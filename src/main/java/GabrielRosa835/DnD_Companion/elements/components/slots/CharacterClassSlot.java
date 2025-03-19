package elements.components.slots;

import common.*;
import elements.entities.options.*;
import lombok.*;
import lombok.experimental.*;
import tactics.*;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@NoArgsConstructor (access = AccessLevel.PACKAGE)
@Builder (setterPrefix = "with")
@Accessors (fluent = true)
@ToString
@Getter
public class CharacterClassSlot implements
		Effect.Applicable<CharacterClassSlot>,
		Replicable
{
	private CharacterClass type;
	private int level;

	@Override
	public CharacterClassSlot applyEffect(Effect<CharacterClassSlot> effect) {
		var result = effect.applyTo(this);
		this.type = result.type;
		this.level = result.level;
		return this;
	}
}