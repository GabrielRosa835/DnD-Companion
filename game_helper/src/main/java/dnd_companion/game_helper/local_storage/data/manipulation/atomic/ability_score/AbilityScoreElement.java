package dnd_companion.game_helper.local_storage.data.manipulation.atomic.ability_score;

import dnd_companion.game_helper.local_storage.data.manipulation.atomic.templates.Element;

public interface AbilityScoreElement extends Element 
{
	public enum Standard implements AbilityScoreElement 
	{
		STRENGTH, DEXTERITY, CONSTITUTION, INTELLIGENCE, WISDOM, CHARISMA;
	}
	
	public class Custom implements AbilityScoreElement 
	{
		private String name;
		@Override public String name() {return name;}
		
		public Custom(String name) {
			this.name = name.toUpperCase();
		}
	}
}
