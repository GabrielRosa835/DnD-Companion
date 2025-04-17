<<<<<<<< HEAD:src/main/java/GabrielRosa835/DnD_Companion/app/tactics/operations/skill/RollSkillTestWithDifferentAbilityScore.java
package GabrielRosa835.dnd_companion.app.tactics.operations.skill;
========
package behaviors.operations.skill;
>>>>>>>> ddb13a8 (Created Catalyst structure):src/main/java/GabrielRosa835/DnD_Companion/behaviors/operations/skill/RollSkillTestWithDifferentAbilityScore.java


import GabrielRosa835.dnd_companion.app.elements.components.groups.*;
import GabrielRosa835.dnd_companion.app.elements.compositions.*;
import GabrielRosa835.dnd_companion.app.elements.entities.character.*;
import GabrielRosa835.dnd_companion.app.fundamentals.*;
import GabrielRosa835.dnd_companion.app.tactics.*;
import lombok.*;
<<<<<<<< HEAD:src/main/java/GabrielRosa835/DnD_Companion/app/tactics/operations/skill/RollSkillTestWithDifferentAbilityScore.java
========
import behaviors.*;
>>>>>>>> ddb13a8 (Created Catalyst structure):src/main/java/GabrielRosa835/DnD_Companion/behaviors/operations/skill/RollSkillTestWithDifferentAbilityScore.java

@NoArgsConstructor (access = AccessLevel.PUBLIC, staticName = "use")
@AllArgsConstructor (access = AccessLevel.PRIVATE)
@With
public class RollSkillTestWithDifferentAbilityScore implements
		Operation<Integer>
{
	private SkillGroup skillGroup;
	private AbilityScore abilityScore;

	public Integer execute() {
		AbilityScoreComposition composition = skillGroup.abilityScoreComposition();
		int abilityScoreModifier = composition.get(abilityScore).modifier();
		int proficiencyModifier = skillGroup.proficiency().proficiencyModifier(composition.character());
		return Dice.D20.roll() + abilityScoreModifier + proficiencyModifier;
	}
}
