package dnd_companion.local_storage.effects;

public class DamageDealEffect extends Effect 
{
	private int damage_dealt;
	
	public DamageDealEffect(Damageable target, int damage_dealt) {
		this.target = target;
		this.damage_dealt = damage_dealt;
	}
	
	@Override protected void code() throws Exception {
		((Damageable) this.target).take_damage(this.damage_dealt);
	}
	
	public interface Damageable extends Target {
		public int current_hp();
		public int current_hp(int new_current_hp);
	}
}
