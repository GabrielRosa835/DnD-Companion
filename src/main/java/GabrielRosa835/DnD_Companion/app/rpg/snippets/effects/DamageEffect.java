package app.rpg.snippets.effects;

import app.rpg.elements.components.*;
import app.rpg.snippets.models.*;
import co.unruly.control.result.*;
import lombok.*;

import static co.unruly.control.result.Introducers.tryTo;
import static co.unruly.control.result.Transformers.*;

@AllArgsConstructor (staticName = "with")
public class DamageEffect implements Effect<HealthComponent>
{
	public final int damage;

	@Override public Result<HealthComponent, Exception> applyTo(HealthComponent target) {
		return Result.success(target.replicate(), Exception.class)
				.then(attempt(tryTo(this::logic)));
	}

	private HealthComponent logic(HealthComponent health) throws Exception {
		int temporaryHitPointsBuffer = health.temporaryHitPoints();
		int currentHitPointsBuffer = health.currentHitPoints();

		temporaryHitPointsBuffer -= damage;
		if (temporaryHitPointsBuffer < 0) {
			currentHitPointsBuffer += temporaryHitPointsBuffer;
			temporaryHitPointsBuffer = 0;
		}

		return health.update(HealthComponent.create(
				currentHitPointsBuffer,
				health.maximumHitPoints(),
				temporaryHitPointsBuffer
		));
	}
}
