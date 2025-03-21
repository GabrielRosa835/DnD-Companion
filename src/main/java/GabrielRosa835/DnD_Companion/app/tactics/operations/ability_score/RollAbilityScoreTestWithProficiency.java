package GabrielRosa835.dnd_companion.app.tactics.operations.ability_score;

import GabrielRosa835.dnd_companion.app.elements.components.groups.*;
import GabrielRosa835.dnd_companion.app.elements.compositions.*;
import GabrielRosa835.dnd_companion.app.elements.entities.character.*;
import GabrielRosa835.dnd_companion.app.fundamentals.*;
import GabrielRosa835.dnd_companion.app.tactics.*;
import lombok.*;

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
