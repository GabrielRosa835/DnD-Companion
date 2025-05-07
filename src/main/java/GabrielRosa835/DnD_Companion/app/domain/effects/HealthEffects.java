package app.domain.effects;

import app.domain.elements.components.*;

public interface HealthEffects
{
	static HealthComponent dealDamage(HealthComponent health, int damage) {
		int temporaryHitPointsBuffer = health.temporaryHitPoints();

		int currentHitPointsBuffer = health.currentHitPoints();

		temporaryHitPointsBuffer -= damage;
		if (temporaryHitPointsBuffer < 0) {
			currentHitPointsBuffer += temporaryHitPointsBuffer;
			temporaryHitPointsBuffer = 0;
		}

		return health
				.withCurrentHitPoints(currentHitPointsBuffer)
				.withTemporaryHitPoints(temporaryHitPointsBuffer);
	}

	static int damageMultiply(int damage, double factor) {
		return (int) Math.floor(damage * factor);
	}
}
