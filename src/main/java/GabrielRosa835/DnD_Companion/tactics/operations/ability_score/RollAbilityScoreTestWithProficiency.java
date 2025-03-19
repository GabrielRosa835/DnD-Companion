package tactics.operations.ability_score;

import elements.components.slots.*;
import elements.compositions.*;
import elements.entities.options.*;
import fundamentals.*;
import lombok.*;
import tactics.*;

@NoArgsConstructor (access = AccessLevel.PUBLIC, staticName = "use")
@AllArgsConstructor (access = AccessLevel.PRIVATE)
@With
public class RollAbilityScoreTestWithProficiency implements Operation<Integer>
{
	private AbilityScoreSlotComposition composition;
	private AbilityScore abilityScore;

	public Integer execute() {
		AbilityScoreSlot abilityScoreSlot = composition.get(abilityScore);
		int proficiencyBonus = composition.character().proficiencyBonus();
		int proficiencyModifier = (int) (proficiencyBonus * abilityScoreSlot.savingThrowProficiency().multiplier());
		return Dice.D20.roll() + abilityScoreSlot.modifier() + proficiencyModifier;
	}
}
