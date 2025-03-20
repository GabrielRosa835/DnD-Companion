package tactics.operations.character;

import elements.components.groups.*;
import elements.compositions.*;
import elements.entities.character.Character;
import lombok.*;
import tactics.*;

import java.util.*;

@AllArgsConstructor
public class CalculateTotalClassLevel
	implements Operation<Integer>
{
	private Collection<CharacterClassGroup> classes;

	public static int with(Collection<CharacterClassGroup> classes) {
		return new CalculateTotalClassLevel(classes).execute();
	}
	public static int with(CharacterClassComposition composition) {
		var classes = composition.classMapping().values();
		return new CalculateTotalClassLevel(classes).execute();
	}
	public static int with(Character character) {
		var classes = character.classes().classMapping().values();
		return new CalculateTotalClassLevel(classes).execute();
	}

	public Integer execute() {
		int sum = 0;
		for (CharacterClassGroup clazz : classes) {
			sum += clazz.level();
		}
		return sum;
	}
}
