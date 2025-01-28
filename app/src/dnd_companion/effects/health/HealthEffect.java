package dnd_companion.effects.health;

import dnd_companion.effects.Effect;
import dnd_companion.entities.addons.components.Health;

public class HealthEffect implements Effect 
{
	private Health health = null;
	
	protected int currentHitPoints;
	protected int maximumHitPoints;
	protected int temporaryHitPoints;
	
	@Override public <O> void loadObject(O object) {
		this.health = (Health) object;
		this.currentHitPoints = health.currentHitPoints();
		this.maximumHitPoints = health.maximumHitPoints();
		this.temporaryHitPoints = health.temporaryHitPoints();
		this.run();
	}
	@Override public void run() {};
	
	public int changeCurrentHitPoints() {
		return currentHitPoints;
	}
	public int changeMaximumHitPoints() {
		return maximumHitPoints;
	}
	public int changeTemporaryHitPoints() {
		return temporaryHitPoints;
	}
}