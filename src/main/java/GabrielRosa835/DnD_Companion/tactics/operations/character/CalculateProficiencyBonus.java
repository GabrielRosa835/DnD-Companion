package tactics.operations.character;

import elements.components.slots.*;
import elements.compositions.*;
import elements.entities.Character;
import lombok.*;
import tactics.*;

@AllArgsConstructor
public class CalculateProficiencyBonus
		implements Operation<Integer>
{
	private int totalClassLevel;

	public static int with(int totalClassLevel) {
		return new CalculateProficiencyBonus(totalClassLevel).execute();
	}
	public static int with(CharacterClassSlotComposition classes) {
		int totalClassLevel = CalculateTotalClassLevel.with(classes);
		return new CalculateProficiencyBonus(totalClassLevel).execute();
	}
	public static int with(Character character) {
		int totalClassLevel = CalculateTotalClassLevel.with(character.classes());
		return new CalculateProficiencyBonus(totalClassLevel).execute();
	}

	public Integer execute() {
		return (int) (Math.ceil(totalClassLevel / 4) + 1);
	}
}
