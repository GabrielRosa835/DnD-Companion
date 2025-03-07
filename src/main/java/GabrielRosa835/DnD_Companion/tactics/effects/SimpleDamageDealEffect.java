package tactics.effects;

import elements.components.*;

public class SimpleDamageDealEffect implements Health.Effect
{
	private Health health = null;

	private int currentHitPoints;
	private int temporaryHitPoints;

	private final int damage;

	public SimpleDamageDealEffect(int damage) {
		this.damage = damage;
	}

	@Override public SimpleDamageDealEffect loadElement(Applicable object) {
		this.health = (Health) object;
		this.currentHitPoints = health.currentHitPoints();
		this.temporaryHitPoints = health.temporaryHitPoints();
		return this;
	}
	@Override public SimpleDamageDealEffect execute() {
		temporaryHitPoints -= damage;
		if (temporaryHitPoints < 0) {
			currentHitPoints += temporaryHitPoints;
			temporaryHitPoints = 0;
		}
		return this;
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
