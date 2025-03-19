package elements.compositions;

import elements.components.slots.*;
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
public class CharacterClassSlotComposition implements
		Effect.Applicable<CharacterClassSlotComposition>,
		Composition<CharacterClass, CharacterClassSlot>,
		Character.Property
{
	private final Character character;

	@Singular("class")
	private Map<CharacterClass, CharacterClassSlot> classMapping = new HashMap<>();

	@Override
	public CharacterClassSlot get(CharacterClass type) {
		return classMapping.get(type);
	}
	@Override
	public CharacterClassSlotComposition add(CharacterClassSlot characterClassSlot) {
		this.classMapping.putIfAbsent(characterClassSlot.type(), characterClassSlot);
		return this;
	}
	@Override
	public CharacterClassSlotComposition remove(CharacterClass characterClass) {
		this.classMapping.remove(characterClass);
		return this;
	}

	@Override
	public CharacterClassSlotComposition applyEffect(Effect<CharacterClassSlotComposition> effect) {
		var result = effect.applyTo(this);
		this.classMapping = result.classMapping;
		return this;
	}
}
