package dnd_companion.effects.health;

public class SimpleHealEffect extends HealthEffect 
{
	private int healValue;
	
	public SimpleHealEffect(int healValue) {
		super();
		this.healValue = healValue;
	}
	
	@Override public void run() {
		currentHitPoints += healValue;
		if (currentHitPoints > maximumHitPoints) {
			currentHitPoints = maximumHitPoints;
		}
	}
}
