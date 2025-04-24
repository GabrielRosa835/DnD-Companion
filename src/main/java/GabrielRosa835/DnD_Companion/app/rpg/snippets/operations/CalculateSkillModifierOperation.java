package app.rpg.snippets.operations;

import app.rpg.elements.actors.CharacterActor;
import app.rpg.elements.options.*;
import app.rpg.elements.options.abilityScores.*;
import app.rpg.elements.options.proficiencies.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CalculateSkillModifierOperation
		implements Operation<Integer> {
	private int abilityScoreValue;
	private int proficiencyBonus;
	private ProficiencyOption skillProficiency;

	public static Integer with(CharacterActor character, SkillOption skill, AbilityScoreOption abilityScore) {
		int abilityScoreValue = character.status().content().get(abilityScore).value();
		int proficiencyBonus = character.keyProperties().proficiencyBonus();
		ProficiencyOption skillProficiency = character.skills().content().get(skill).proficiency();
		return new CalculateSkillModifierOperation(abilityScoreValue, proficiencyBonus, skillProficiency).process();
	}

	public static Integer with(CharacterActor character, SkillOption skill) {
		AbilityScoreOption skillStandardAbilityScore = skill.standardAbilityScore();
		int abilityScoreValue = character.status().content().get(skillStandardAbilityScore).value();
		int proficiencyBonus = character.keyProperties().proficiencyBonus();
		ProficiencyOption skillProficiency = character.skills().content().get(skill).proficiency();
		return new CalculateSkillModifierOperation(abilityScoreValue, proficiencyBonus, skillProficiency).process();
	}

	public static Integer with(int abilityScoreValue, int proficiencyBonus, ProficiencyOption skillProficiency) {
		return new CalculateSkillModifierOperation(abilityScoreValue, proficiencyBonus, skillProficiency).process();
	}

	@Override
	public Integer process() {
		return (int) (skillProficiency.multiplier() * proficiencyBonus) + abilityScoreValue;
	}
}
