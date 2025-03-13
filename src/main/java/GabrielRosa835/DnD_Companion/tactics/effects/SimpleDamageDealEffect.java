package tactics.effects;

import elements.components.*;
import lombok.*;
import tactics.*;

@NoArgsConstructor (access = AccessLevel.PUBLIC, staticName = "use")
@AllArgsConstructor (access = AccessLevel.PRIVATE)
@With
public class SimpleDamageDealEffect	implements Effect<Health>
{
	private int damage;

	@Override public Health applyTo(Health h) {
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
