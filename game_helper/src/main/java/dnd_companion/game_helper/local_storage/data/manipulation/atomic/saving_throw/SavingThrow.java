package dnd_companion.game_helper.local_storage.data.manipulation.atomic.saving_throw;

import dnd_companion.game_helper.local_storage.data.manipulation.atomic.templates.Element;

public interface SavingThrow extends Element
{
	public enum Standard implements SavingThrow
	{
		STRENGTH, DEXTERITY, CONSTITUTION, INTELLIGENCE, WISDOM, CHARISMA 
	}
	
	public class Custom implements SavingThrow
	{
		private String name;
		public String name() {return this.name;}
		
		public Custom(String name) {
			this.name = name.toUpperCase();
		}
	}
}
