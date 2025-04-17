<<<<<<<< HEAD:src/main/java/GabrielRosa835/DnD_Companion/app/tactics/operations/character/CalculateProficiencyBonus.java
package GabrielRosa835.dnd_companion.app.tactics.operations.character;
========
package behaviors.operations.character;
>>>>>>>> ddb13a8 (Created Catalyst structure):src/main/java/GabrielRosa835/DnD_Companion/behaviors/operations/character/CalculateProficiencyBonus.java

import GabrielRosa835.dnd_companion.app.elements.compositions.*;
import GabrielRosa835.dnd_companion.app.elements.entities.character.Character;
import GabrielRosa835.dnd_companion.app.tactics.*;
import lombok.*;
<<<<<<<< HEAD:src/main/java/GabrielRosa835/DnD_Companion/app/tactics/operations/character/CalculateProficiencyBonus.java
========
import behaviors.*;
>>>>>>>> ddb13a8 (Created Catalyst structure):src/main/java/GabrielRosa835/DnD_Companion/behaviors/operations/character/CalculateProficiencyBonus.java

@AllArgsConstructor
public class CalculateProficiencyBonus
		implements Operation<Integer>
{
	private int totalClassLevel;

	public static int with(int totalClassLevel) {
		return new CalculateProficiencyBonus(totalClassLevel).execute();
	}
	public static int with(CharacterClassComposition classes) {
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
