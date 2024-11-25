package dnd_companion.local_storage.data.manipulation.archived.atomic.saving_throw;

import dnd_companion.local_storage.data.manipulation.archived.atomic.templates.Element;

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
