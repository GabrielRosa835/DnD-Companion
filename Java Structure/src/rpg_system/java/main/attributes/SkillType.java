package main.attributes;

import atomic.AtomType;
import atomic.ability_score.AbilityScoreElement;

public interface SkillType extends AtomType 
{
	public AbilityScoreElement ability_score_type();
	
	public enum StandardType implements SkillType
	{
		ATHLETICS       (AbilityScore.AbilityScoreElement.STRENGTH),
		ACROBATICS      (AbilityScore.AbilityScoreElement.DEXTERITY),
		SLEIGHT_OF_HAND (AbilityScore.AbilityScoreElement.DEXTERITY),
		STEALTH         (AbilityScore.AbilityScoreElement.DEXTERITY),
		ANIMAL_HANDLING (AbilityScore.AbilityScoreElement.WISDOM),
		INSIGHT         (AbilityScore.AbilityScoreElement.WISDOM),
		MEDICINE        (AbilityScore.AbilityScoreElement.WISDOM),
		PERCEPTION      (AbilityScore.AbilityScoreElement.WISDOM),
		SURVIVAL        (AbilityScore.AbilityScoreElement.WISDOM),
		ARCANA          (AbilityScore.AbilityScoreElement.INTELLIGENCE),
		HISTORY         (AbilityScore.AbilityScoreElement.INTELLIGENCE),
		INVESTIGATION   (AbilityScore.AbilityScoreElement.INTELLIGENCE),
		NATURE          (AbilityScore.AbilityScoreElement.INTELLIGENCE),
		RELIGION        (AbilityScore.AbilityScoreElement.INTELLIGENCE),
		DECEPTION       (AbilityScore.AbilityScoreElement.CHARISMA),
		INTIMIDATION    (AbilityScore.AbilityScoreElement.CHARISMA),
		PERFORMANCE     (AbilityScore.AbilityScoreElement.CHARISMA),
		PERSUASION      (AbilityScore.AbilityScoreElement.CHARISMA);

		private AbilityScoreElement ability_score_type;
		public AbilityScoreElement ability_score_type() {return this.ability_score_type;}

		private StandardType(AbilityScoreElement ability_score_type) {
			this.ability_score_type = ability_score_type;
		}
	}
	
	public class CustomType implements SkillType 
	{
		private String name;
		public String name() {return name;}
		
		private AbilityScoreElement ability_score_type;
		public AbilityScoreElement ability_score_type() {return this.ability_score_type;}
		
		public CustomType(String name, AbilityScoreElement ability_score_type) {
			this.name = name.toUpperCase();
			this.ability_score_type = ability_score_type; 
		}
	}
}
