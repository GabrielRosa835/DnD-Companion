package dnd_companion.effects.health;

import dnd_companion.actors.components.rules.Health;

public class SimpleDamageDealEffect implements Health.HealthEffect
{
	private Health health = null;
	
	private int currentHitPoints;
	private int temporaryHitPoints;
	
	private int damage;
	
	public SimpleDamageDealEffect(int damage) {
		this.damage = damage;
	}
	
	@Override public <O> void loadObject(O object) {
		this.health = (Health) object;
		this.currentHitPoints = health.currentHitPoints();
		this.temporaryHitPoints = health.temporaryHitPoints();
		this.run();
	}
	@Override public void run() {
		temporaryHitPoints -= damage;
		if (temporaryHitPoints < 0) {			
			currentHitPoints += temporaryHitPoints;
			temporaryHitPoints = 0;
		}
	}
	
	@Override public int changeCurrentHitPoints() {
		return currentHitPoints;
	}
	@Override public int changeMaximumHitPoints() {
		return health.maximumHitPoints();
	}
	@Override public int changeTemporaryHitPoints() {
		return temporaryHitPoints;
	}
	
	
}
