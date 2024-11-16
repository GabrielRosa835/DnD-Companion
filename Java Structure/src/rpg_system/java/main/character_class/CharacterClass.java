package main.character_class;

import dnd.characters.attributes.AbilityScore.SavingThrow;
import dnd.characters.system.atomic.dice.Dice;
import dnd.characters.attributes.Skill;

public class CharacterClass {
	public Classes character_class;
	public int level;
	
	public interface Classes {
		public int level();
		public Dice hit_dice();
		public SavingThrow[] saving_throw_proficiencies();
		public Skill[] skills_proficiencies();
		public 
	}
}	
