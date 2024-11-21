package dnd_companion.game_helper.local_storage.data.manipulation.atomic.damage;

import dnd_companion.game_helper.local_storage.data.manipulation.atomic.templates.Element;

public interface Damage extends Element 
{
	public enum Standard implements Damage {
		ACID, BLUDGEONING, COLD, FIRE, FORCE, LIGHTNING, NECROTIC, 
		PIERCING, POISON, PSYCHIC, RADIANT, SLASHING, THUNDER;
	}
	public class Custom implements Damage 
	{
		private String name;
		public String name() {return name;}
		
		public Custom(String name) {
			this.name = name.toUpperCase();
		}
	}	
}
