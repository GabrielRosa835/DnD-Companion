package dnd_companion.actors.components.rules;

import dnd_companion.actors.models.Component;
import dnd_companion.effects.Effect;
import dnd_companion.effects.Effectable;

public class Health implements Component, Effectable
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
	
	@Override public Health applyEffect(Effect e) {
		HealthEffect effect = (HealthEffect) e;
		effect.loadObject(this);
		this.currentHitPoints = effect.changeCurrentHitPoints();
		this.maximumHitPoints = effect.changeMaximumHitPoints();
		this.temporaryHitPoints = effect.changeTemporaryHitPoints();
		return this;
	}
	
	public interface HealthEffect extends Effect {		
		public int changeCurrentHitPoints();
		public int changeMaximumHitPoints();
		public int changeTemporaryHitPoints();
	}
}
