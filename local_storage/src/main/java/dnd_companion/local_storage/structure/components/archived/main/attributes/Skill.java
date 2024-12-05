package dnd_companion.local_storage.structure.components.archived.main.attributes;

import atomic.Technique;
import dnd_companion.local_storage.structure.components.archived.atomic.ability_score.AbilityScoreElement;

public class Skill implements Technique
{
	private Character character;

	private ProficiencyType proficiency;
	public ProficiencyType proficiency() {return this.proficiency;}

	private SkillType type;
	public SkillType type() {return this.type;}

	public Skill(
		SkillType type,
		ProficiencyType proficiency,
		Character character
	) {
		this.type = type;
		this.proficiency = proficiency;
		this.character = character;
	}

	public int modifier() {
		AbilityScoreElement ability_score = this.character.status.mapping().get(this.type.ability_score_type());
		return (int) (ability_score.modifier() + (this.character.proficiency_bonus * proficiency.multiplier()));
	}

	@Override public SkillProficiencyOptions to_proficiency() {
		return new SkillProficiencyOptions(this, this.proficiency);
	}
}