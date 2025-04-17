package app.rpg.strategies.effects;

import app.strategies.EffectBase;
import app.rpg.elements.components.*;
import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor (access = AccessLevel.PRIVATE)
public class DamageEffect
	extends EffectBase
{
	@With public final int damage;

	private HealthComponent target;
	private int temporaryHitPointsBuffer;
	private int currentHitPointsBuffer;

	@Override protected void setup () {
		target = (HealthComponent) object;
		currentHitPointsBuffer = target.currentHitPoints();
		temporaryHitPointsBuffer = target.temporaryHitPoints();
	}
	@Override protected void execute () {
		temporaryHitPointsBuffer -= damage;
		if (temporaryHitPointsBuffer < 0) {
			currentHitPointsBuffer += temporaryHitPointsBuffer;
			temporaryHitPointsBuffer = 0;
		}
	}
	@Override protected HealthComponent assemble () {
		return HealthComponent.create(
				currentHitPointsBuffer,
				temporaryHitPointsBuffer,
				target.maximumHitPoints());
	}
}
