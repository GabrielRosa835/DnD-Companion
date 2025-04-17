<<<<<<<< HEAD:src/main/java/GabrielRosa835/DnD_Companion/app/tactics/operations/character/CalculateTotalClassLevel.java
package GabrielRosa835.dnd_companion.app.tactics.operations.character;
========
package behaviors.operations.character;
>>>>>>>> ddb13a8 (Created Catalyst structure):src/main/java/GabrielRosa835/DnD_Companion/behaviors/operations/character/CalculateTotalClassLevel.java

import GabrielRosa835.dnd_companion.app.elements.components.groups.*;
import GabrielRosa835.dnd_companion.app.elements.compositions.*;
import GabrielRosa835.dnd_companion.app.elements.entities.character.Character;
import GabrielRosa835.dnd_companion.app.tactics.*;
import lombok.*;
<<<<<<<< HEAD:src/main/java/GabrielRosa835/DnD_Companion/app/tactics/operations/character/CalculateTotalClassLevel.java
========
import behaviors.*;
>>>>>>>> ddb13a8 (Created Catalyst structure):src/main/java/GabrielRosa835/DnD_Companion/behaviors/operations/character/CalculateTotalClassLevel.java

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
