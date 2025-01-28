package dnd_companion.effects.health;

public class DoubleDamageDealEffect extends HealthEffect
{
	private int damage;
	
	public DoubleDamageDealEffect(int damage) {
		super();
		this.damage = damage;
	}
	
	@Override public void run() {
		temporaryHitPoints -= 2*damage;
		if (temporaryHitPoints < 0) {			
			currentHitPoints += temporaryHitPoints;
			temporaryHitPoints = 0;
		}
	}
}
