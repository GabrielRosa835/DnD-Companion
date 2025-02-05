package dnd_companion.effects.health;

import dnd_companion.actors.components.rules.Health;

public class SimpleHealEffect implements Health.HealthEffect 
{
	private Health health = null;
	
	private int currentHitPoints;
	private int maximumHitPoints;
	
	private int healValue;
	
	public SimpleHealEffect(int healValue) {
		this.healValue = healValue;
	}
	
	@Override public <O> void loadObject(O object) {
		this.health = (Health) object;
		this.currentHitPoints = health.currentHitPoints();
		this.maximumHitPoints = health.maximumHitPoints();
		this.run();
	}
	@Override public void run() {
		currentHitPoints += healValue;
		if (currentHitPoints > maximumHitPoints) {
			currentHitPoints = maximumHitPoints;
		}
	}
	
	@Override public int changeCurrentHitPoints() {
		return currentHitPoints;
	}
	@Override public int changeMaximumHitPoints() {
		return maximumHitPoints;
	}
	@Override public int changeTemporaryHitPoints() {
		return health.temporaryHitPoints();
	}
}
