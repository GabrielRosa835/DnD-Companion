package app.rpg.snippets.operations;

import app.rpg.elements.actors.CharacterActor;
import app.rpg.elements.components.CharacterClassComponent;
import app.rpg.elements.compositions.*;
import lombok.*;

import java.util.*;

@AllArgsConstructor
public class CalculateTotalClassLevel
		implements Operation<Integer> {
	private Collection<CharacterClassComponent> classes;

	public static int with(CharacterActor CharacterActor) {
		var classes = CharacterActor.classes().content().values();
		return new CalculateTotalClassLevel(classes).process();
	}

	public static int with(CharacterClassComposition composition) {
		var classes = composition.content().values();
		return new CalculateTotalClassLevel(classes).process();
	}

	public static int with(Collection<CharacterClassComponent> classes) {
		return new CalculateTotalClassLevel(classes).process();
	}

	public Integer process() {
		int sum = 0;
		for (CharacterClassComponent clazz : classes) {
			sum += clazz.level();
		}
		return sum;
	}
}
