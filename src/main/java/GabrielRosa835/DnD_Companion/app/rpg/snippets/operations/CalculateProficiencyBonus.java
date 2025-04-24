package app.rpg.snippets.operations;

import app.rpg.elements.actors.CharacterActor;
import app.rpg.elements.compositions.*;
import lombok.*;

@AllArgsConstructor
public class CalculateProficiencyBonus
		implements Operation<Integer> {
	private int totalClassLevel;

	public static int with(int totalClassLevel) {
		return new CalculateProficiencyBonus(totalClassLevel).process();
	}

	public static int with(CharacterClassComposition classes) {
		int totalClassLevel = CalculateTotalClassLevel.with(classes);
		return new CalculateProficiencyBonus(totalClassLevel).process();
	}

	public static int with(CharacterActor CharacterActor) {
		int totalClassLevel = CalculateTotalClassLevel.with(CharacterActor.classes());
		return new CalculateProficiencyBonus(totalClassLevel).process();
	}

	public Integer process() {
		return (int) (Math.ceil((double) totalClassLevel / 4) + 1);
	}
}
