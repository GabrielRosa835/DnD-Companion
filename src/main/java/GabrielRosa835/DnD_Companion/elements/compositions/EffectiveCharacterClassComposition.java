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
@Getter
@Accessors(fluent = true)
public class EffectiveCharacterClassComposition implements
		Effect.Applicable<EffectiveCharacterClassComposition>,
		Composition<CharacterClass, EffectiveCharacterClass>,
		Character.Property
{
	private final Character character;

	private Map<CharacterClass, EffectiveCharacterClass> classMapping = new HashMap<>();

	public EffectiveCharacterClass get(CharacterClass type) {
		return classMapping.get(type);
	}
	public EffectiveCharacterClassComposition add(EffectiveCharacterClass effectiveCharacterClass) {
		this.classMapping.putIfAbsent(effectiveCharacterClass.type(), effectiveCharacterClass);
		return this;
	}
	public EffectiveCharacterClassComposition remove(CharacterClass characterClass) {
		this.classMapping.remove(characterClass);
		return this;
	}

	public EffectiveCharacterClassComposition applyEffect(Effect<EffectiveCharacterClassComposition> effect) {
		EffectiveCharacterClassComposition result = effect.applyTo(this);
		this.classMapping.putAll(result.classMapping);
		return this;
	}
}
