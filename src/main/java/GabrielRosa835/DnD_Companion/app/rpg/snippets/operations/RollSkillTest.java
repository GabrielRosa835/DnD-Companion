package app.rpg.snippets.operations;

import app.rpg.elements.actors.CharacterActor;
import app.rpg.elements.options.*;
import app.rpg.elements.options.abilityScores.*;
import app.rpg.elements.options.proficiencies.*;
import lombok.*;

@AllArgsConstructor
public class RollSkillTest
		implements Operation<Integer> {
	private int skillModifier;

	public static RollSkillTest with(CharacterActor character, SkillOption skill, AbilityScoreOption abilityScore) {
		int skillModifier = CalculateSkillModifierOperation.with(character, skill, abilityScore);
		return new RollSkillTest(skillModifier);
	}

	public static RollSkillTest with(CharacterActor character, SkillOption skill) {
		int skillModifier = CalculateSkillModifierOperation.with(character, skill);
		return new RollSkillTest(skillModifier);
	}

	public static RollSkillTest with(int abilityScoreValue, int proficiencyBonus, ProficiencyOption skillProficiency) {
		int skillModifier = CalculateSkillModifierOperation.with(abilityScoreValue, proficiencyBonus, skillProficiency);
		return new RollSkillTest(skillModifier);
	}

	@Override
	public Integer process() {
		int D20Roll = RollDiceOperation.with("D20");
		return D20Roll + skillModifier;
	}
}
