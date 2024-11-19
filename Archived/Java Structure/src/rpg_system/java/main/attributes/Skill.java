package main.attributes;

import atomic.Proficiency;
import atomic.Technique;
import atomic.ability_score.AbilityScoreElement;
import main.Character;

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
	
	@Override public Proficiency to_proficiency() {
		return new Proficiency(this, this.proficiency);
	}
}