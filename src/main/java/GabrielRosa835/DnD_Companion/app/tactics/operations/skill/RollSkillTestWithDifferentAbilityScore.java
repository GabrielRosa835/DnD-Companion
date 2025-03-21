package GabrielRosa835.dnd_companion.app.tactics.operations.skill;


import GabrielRosa835.dnd_companion.app.elements.components.groups.*;
import GabrielRosa835.dnd_companion.app.elements.compositions.*;
import GabrielRosa835.dnd_companion.app.elements.entities.character.*;
import GabrielRosa835.dnd_companion.app.fundamentals.*;
import GabrielRosa835.dnd_companion.app.tactics.*;
import lombok.*;

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
