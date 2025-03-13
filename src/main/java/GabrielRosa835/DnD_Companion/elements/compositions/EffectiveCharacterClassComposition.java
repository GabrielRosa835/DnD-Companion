package elements.compositions;

import common.*;
import elements.components.character.CharacterClass;
import elements.components.character.EffectiveCharacterClass;
import elements.models.*;
import lombok.*;
import lombok.experimental.*;
import tactics.*;

import java.util.*;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@ToString
@Getter
@Accessors(fluent = true)
public class EffectiveCharacterClassComposition implements Replicable, Effect.Applicable, Composition<EffectiveCharacterClass> {
	private Map<CharacterClass.Type, EffectiveCharacterClass> classMapping = new HashMap<>();

	public EffectiveCharacterClass get(CharacterClass.Type type) {
		return classMapping.get(type);
	}

	public EffectiveCharacterClassComposition add(EffectiveCharacterClass characterClass) {
		this.classMapping.putIfAbsent(characterClass.referencedClass().type(), characterClass);
		return this;
	}

	public int getLevel(CharacterClass characterClass) {
		return get(characterClass.type()).classLevel();
	}

	public int totalLevel() {
		int sum = 0;
		for (EffectiveCharacterClass effectiveClass : classMapping.values()) {
			sum += effectiveClass.classLevel();
		}
		return sum;
	}

	public EffectiveCharacterClassComposition applyEffect(tactics.Effect effect) {
		Effect e = (Effect) effect;
		e.loadObject(this);
		this.classMapping = e.changeClassMapping();
		return this;
	}

	public interface Effect extends tactics.Effect {
		Map<CharacterClass.Type, EffectiveCharacterClass> changeClassMapping();
	}
}
