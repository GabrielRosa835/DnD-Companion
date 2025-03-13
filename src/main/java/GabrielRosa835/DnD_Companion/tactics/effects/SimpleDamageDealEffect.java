package tactics.effects;

import elements.components.character.Health;
import tactics.*;

public class SimpleDamageDealEffect	implements Effect<Health>
{
	private final int damage;

	public SimpleDamageDealEffect(int damage) {
		this.damage = damage;
	}

	@Override public Health apply(Health h) {
		int currentHitPointsBuffer = h.currentHitPoints();
		int temporaryHitPointsBuffer = h.temporaryHitPoints();

		temporaryHitPointsBuffer -= damage;
		if (temporaryHitPointsBuffer < 0) {
			currentHitPointsBuffer += temporaryHitPointsBuffer;
			temporaryHitPointsBuffer = 0;
		}

		return Health.builder()
				.currentHitPoints(currentHitPointsBuffer)
				.temporaryHitPoints(temporaryHitPointsBuffer)
				.maximumHitPoints(h.maximumHitPoints())
				.build();
	}
}
