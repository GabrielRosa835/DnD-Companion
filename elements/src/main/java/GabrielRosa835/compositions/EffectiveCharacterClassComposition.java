package GabrielRosa835.compositions;

import GabrielRosa835.*;
import GabrielRosa835.components.*;
import GabrielRosa835.models.*;
import lombok.*;
import lombok.experimental.*;

import java.util.*;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@ToString
@Getter
@Accessors(fluent = true)
public class EffectiveCharacterClassComposition implements Replicable, Component, Effectable, Composition<EffectiveCharacterClass>
{
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

	public EffectiveCharacterClassComposition applyEffect(GabrielRosa835.Effect effect) {
		Effect e = (Effect) effect;
		e.loadObject(this);
		this.classMapping = e.changeClassMapping();
		return this;
	}
	public interface Effect extends GabrielRosa835.Effect {
		Map<CharacterClass.Type, EffectiveCharacterClass> changeClassMapping();
	}
}
