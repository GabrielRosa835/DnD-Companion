package dnd_companion.local_storage.archived.components.atomic.saving_throw;

import dnd_companion.local_storage.archived.components.atomic.ability_score.AbilityScoreGroup;
import dnd_companion.local_storage.archived.components.atomic.templates.TechniqueGroup;
import dnd_companion.local_storage.archived.components.main.attributes.SkillProficiencyOptions;

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