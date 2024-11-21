package dnd_companion.game_helper.local_storage.data.manipulation.atomic.saving_throw;

import dnd_companion.game_helper.local_storage.data.manipulation.atomic.ability_score.AbilityScoreGroup;
import dnd_companion.game_helper.local_storage.data.manipulation.atomic.templates.TechniqueGroup;
import dnd_companion.game_helper.local_storage.data.manipulation.main.attributes.SkillProficiencyOptions;

public class SavingThrowTechnique extends TechniqueGroup<SavingThrow>
{
	private AbilityScoreGroup ability_score;
	
	public int modifier() {
		return (int) (this.ability_score.modifier() + (this.character.proficiency_bonus * this.skillProficiencyOptions.multiplier()));
	}
	
	public SavingThrowTechnique(
		Character character,
		AbilityScoreGroup ability_score,
		SavingThrow element,
		SkillProficiencyOptions skillProficiencyOptions
	) {
		super(character, element, skillProficiencyOptions);
		this.ability_score = ability_score;
	}
}