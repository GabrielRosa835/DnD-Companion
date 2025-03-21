package GabrielRosa835.dnd_companion.app.elements.compositions;


import GabrielRosa835.dnd_companion.app.elements.components.groups.*;
import GabrielRosa835.dnd_companion.app.elements.entities.character.*;
import GabrielRosa835.dnd_companion.app.elements.entities.character.Character;
import GabrielRosa835.dnd_companion.app.elements.models.*;
import GabrielRosa835.dnd_companion.app.tactics.*;
import lombok.*;
import lombok.experimental.*;

import java.util.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Accessors(fluent = true)
@ToString
@Builder (setterPrefix = "with")
@Getter
public class CharacterClassComposition implements
		Effect.Applicable<CharacterClassComposition>,
		Composition<CharacterClass, CharacterClassGroup>,
		Character.Property
{
	private Character character;

	@Singular("class")
	private Map<CharacterClass, CharacterClassGroup> classMapping;

	@Override
	public CharacterClassGroup get(CharacterClass type) {
		return classMapping.get(type);
	}
	@Override
	public CharacterClassComposition add(CharacterClassGroup characterClassGroup) {
		this.classMapping.putIfAbsent(characterClassGroup.type(), characterClassGroup);
		return this;
	}
	@Override
	public CharacterClassComposition remove(CharacterClass characterClass) {
		this.classMapping.remove(characterClass);
		return this;
	}

	@Override
	public CharacterClassComposition applyEffect(Effect<CharacterClassComposition> effect) {
		var result = effect.applyTo(this);
		this.classMapping = result.classMapping;
		return this;
	}
}
