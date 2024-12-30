package atomic.saving_throw;

import atomic.Element;

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
