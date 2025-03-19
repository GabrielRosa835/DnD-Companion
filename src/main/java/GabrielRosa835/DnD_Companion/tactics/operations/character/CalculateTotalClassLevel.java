package tactics.operations.character;

import elements.components.slots.*;
import elements.compositions.*;
import elements.entities.Character;
import lombok.*;
import tactics.*;

import java.util.*;

@AllArgsConstructor
public class CalculateTotalClassLevel
	implements Operation<Integer>
{
	private Collection<CharacterClassSlot> classes;

	public static int with(Collection<CharacterClassSlot> classes) {
		return new CalculateTotalClassLevel(classes).execute();
	}
	public static int with(CharacterClassSlotComposition composition) {
		var classes = composition.classMapping().values();
		return new CalculateTotalClassLevel(classes).execute();
	}
	public static int with(Character character) {
		var classes = character.classes().classMapping().values();
		return new CalculateTotalClassLevel(classes).execute();
	}

	public Integer execute() {
		int sum = 0;
		for (CharacterClassSlot clazz : classes) {
			sum += clazz.level();
		}
		return sum;
	}
}
