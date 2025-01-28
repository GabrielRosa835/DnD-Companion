package dnd_companion.entities.addons.components;

import dnd_companion.effects.health.HealthEffect;
import dnd_companion.entities.addons.models.Component;

public class Health implements Component
{
	private int currentHitPoints;
	private int maximumHitPoints;
	private int temporaryHitPoints;
	
	public int currentHitPoints() {return currentHitPoints;}
	public int maximumHitPoints() {return maximumHitPoints;}
	public int temporaryHitPoints() {return temporaryHitPoints;}
	
	public Health(int currentHitPoints, int maximumHitPoints, int temporaryHitPoints) {
		this.currentHitPoints = currentHitPoints;
		this.maximumHitPoints = maximumHitPoints;
		this.temporaryHitPoints = temporaryHitPoints;
	}
	private Health(Health original) {
		this(original.currentHitPoints, original.maximumHitPoints, original.temporaryHitPoints);
	}
	
	@Override public Health clone() {
		return new Health(this);
	}
	@Override public String toString() {
		return String.format("Health[current=%d, maximum=%d, temporary=%d]",
				currentHitPoints, maximumHitPoints, temporaryHitPoints);
	}
	
	public Health applyEffect(HealthEffect effect) {
		effect.loadObject(this);
		this.currentHitPoints = effect.changeCurrentHitPoints();
		this.maximumHitPoints = effect.changeMaximumHitPoints();
		this.temporaryHitPoints = effect.changeTemporaryHitPoints();
		return this;
	}
}
