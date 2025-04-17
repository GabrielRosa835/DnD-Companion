package elements.compositions;

import elements.components.groups.*;
import elements.entities.character.Character;
import elements.entities.character.CharacterClass;
import elements.models.*;
import lombok.*;
import lombok.experimental.*;
import behaviors.*;

import java.util.*;

@RequiredArgsConstructor
@Builder (setterPrefix = "with")
@Accessors (fluent = true)
@ToString
@Getter
public class CharacterClassComposition implements
		Effect.Applicable<CharacterClassComposition>,
		Composition<CharacterClass, CharacterClassGroup>,
		Character.Property
{
	private final Character character;

	@Singular("class")
	private Map<CharacterClass, CharacterClassGroup> classMapping = new HashMap<>();

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
