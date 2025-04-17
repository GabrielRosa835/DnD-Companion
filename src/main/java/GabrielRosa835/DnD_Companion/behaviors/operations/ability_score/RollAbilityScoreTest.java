<<<<<<<< HEAD:src/main/java/GabrielRosa835/DnD_Companion/app/tactics/operations/ability_score/RollAbilityScoreTest.java
package GabrielRosa835.dnd_companion.app.tactics.operations.ability_score;

import GabrielRosa835.dnd_companion.app.elements.components.groups.*;
import GabrielRosa835.dnd_companion.app.elements.compositions.*;
import GabrielRosa835.dnd_companion.app.elements.entities.character.*;
import GabrielRosa835.dnd_companion.app.elements.entities.character.Character;
import GabrielRosa835.dnd_companion.app.fundamentals.*;
import GabrielRosa835.dnd_companion.app.tactics.*;
import lombok.*;
========
package behaviors.operations.ability_score;

import elements.components.groups.*;
import elements.compositions.*;
import elements.entities.character.AbilityScore;
import elements.entities.character.Character;
import fundamentals.*;
import behaviors.*;
>>>>>>>> ddb13a8 (Created Catalyst structure):src/main/java/GabrielRosa835/DnD_Companion/behaviors/operations/ability_score/RollAbilityScoreTest.java

public class RollAbilityScoreTest implements Operation<Integer>
{
	private final int abilityScoreModifier;

	public RollAbilityScoreTest (int abilityScoreModifier) {
		this.abilityScoreModifier = abilityScoreModifier;
	}

	public static int with(int abilityScoreModifier) {
		return new RollAbilityScoreTest(abilityScoreModifier).execute();
	}
	public static int with(AbilityScoreGroup abilityScoreGroup) {
		int abilityScoreModifier = abilityScoreGroup.modifier();
		return new RollAbilityScoreTest(abilityScoreModifier).execute();
	}
	public static int with(AbilityScoreComposition composition, AbilityScore abilityScore) {
		int abilityScoreModifier = composition.get(abilityScore).modifier();
		return new RollAbilityScoreTest(abilityScoreModifier).execute();
	}
	public static int with(Character character, AbilityScore abilityScore) {
		int abilityScoreModifier = character.status().get(abilityScore).modifier();
		return new RollAbilityScoreTest(abilityScoreModifier).execute();
	}

	@Override public Integer execute() {
		return Dice.D20.roll() + abilityScoreModifier;
	}
}
