package elements.compositions;

import elements.components.effective.*;
import elements.entities.Character;
import elements.entities.options.*;
import elements.models.*;
import lombok.*;
import lombok.experimental.*;
import tactics.*;

import java.util.*;

@RequiredArgsConstructor
@Builder (setterPrefix = "with")
@Accessors (fluent = true)
@ToString
@Getter
public class EffectiveCharacterClassComposition implements
		Effect.Applicable<EffectiveCharacterClassComposition>,
		Composition<CharacterClass, EffectiveCharacterClass>,
		Character.Property
{
	private final Character character;

	@Singular("class")
	private Map<CharacterClass, EffectiveCharacterClass> classMapping = new HashMap<>();

	@Override
	public EffectiveCharacterClass get(CharacterClass type) {
		return classMapping.get(type);
	}
	@Override
	public EffectiveCharacterClassComposition add(EffectiveCharacterClass effectiveCharacterClass) {
		this.classMapping.putIfAbsent(effectiveCharacterClass.type(), effectiveCharacterClass);
		return this;
	}
	@Override
	public EffectiveCharacterClassComposition remove(CharacterClass characterClass) {
		this.classMapping.remove(characterClass);
		return this;
	}

	@Override
	public EffectiveCharacterClassComposition applyEffect(Effect<EffectiveCharacterClassComposition> effect) {
		var result = effect.applyTo(this);
		this.classMapping.putAll(result.classMapping);
		return this;
	}
}
