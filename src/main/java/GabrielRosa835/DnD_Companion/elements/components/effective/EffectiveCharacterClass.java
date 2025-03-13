package elements.components.effective;

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
public class EffectiveCharacterClass implements
		Effect.Applicable<EffectiveCharacterClass>,
		Replicable
{
	private CharacterClass type;
	private int classLevel;

	@Override
	public EffectiveCharacterClass applyEffect(Effect<EffectiveCharacterClass> effect) {
		var result = effect.applyTo(this);
		this.type = result.type;
		this.classLevel = result.classLevel;
		return this;
	}
}