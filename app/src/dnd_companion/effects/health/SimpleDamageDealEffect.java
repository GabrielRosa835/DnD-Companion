package dnd_companion.effects.health;

public class SimpleDamageDealEffect extends HealthEffect
{
	private int damage;
	
	public SimpleDamageDealEffect(int damage) {
		super();
		this.damage = damage;
	}
	
	@Override public void run() {
		temporaryHitPoints -= damage;
		if (temporaryHitPoints < 0) {			
			currentHitPoints += temporaryHitPoints;
			temporaryHitPoints = 0;
		}
	}
}
