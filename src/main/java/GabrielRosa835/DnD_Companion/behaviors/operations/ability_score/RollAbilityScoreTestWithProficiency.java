<<<<<<<< HEAD:src/main/java/GabrielRosa835/DnD_Companion/app/tactics/operations/ability_score/RollAbilityScoreTestWithProficiency.java
package GabrielRosa835.dnd_companion.app.tactics.operations.ability_score;
========
package behaviors.operations.ability_score;
>>>>>>>> ddb13a8 (Created Catalyst structure):src/main/java/GabrielRosa835/DnD_Companion/behaviors/operations/ability_score/RollAbilityScoreTestWithProficiency.java

import GabrielRosa835.dnd_companion.app.elements.components.groups.*;
import GabrielRosa835.dnd_companion.app.elements.compositions.*;
import GabrielRosa835.dnd_companion.app.elements.entities.character.*;
import GabrielRosa835.dnd_companion.app.fundamentals.*;
import GabrielRosa835.dnd_companion.app.tactics.*;
import lombok.*;
<<<<<<<< HEAD:src/main/java/GabrielRosa835/DnD_Companion/app/tactics/operations/ability_score/RollAbilityScoreTestWithProficiency.java
========
import behaviors.*;
>>>>>>>> ddb13a8 (Created Catalyst structure):src/main/java/GabrielRosa835/DnD_Companion/behaviors/operations/ability_score/RollAbilityScoreTestWithProficiency.java

@NoArgsConstructor (access = AccessLevel.PUBLIC, staticName = "use")
@AllArgsConstructor (access = AccessLevel.PRIVATE)
@With
public class RollAbilityScoreTestWithProficiency implements Operation<Integer>
{
	private AbilityScoreComposition composition;
	private AbilityScore abilityScore;

	public Integer execute() {
		AbilityScoreGroup abilityScoreGroup = composition.get(abilityScore);
		int proficiencyBonus = composition.character().keyProperties().proficiencyBonus();
		int proficiencyModifier = (int) (proficiencyBonus * abilityScoreGroup.savingThrowProficiency().multiplier());
		return Dice.D20.roll() + abilityScoreGroup.modifier() + proficiencyModifier;
	}
}
