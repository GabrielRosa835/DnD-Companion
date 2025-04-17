package behaviors.effects;

import elements.components.*;
import elements.compositions.ResistanceComposition;
import lombok.*;
import behaviors.*;
import lombok.experimental.Accessors;

import java.util.Set;

public class DamageEffect extends EffectModel<Health>
{
	public int damage;

	public DamageEffect (int damage) {
		this.damage = damage;
	}

	private int temporaryHitPointsBuffer;
	private int currentHitPointsBuffer;

	@Override protected void setup () {
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
	@Override protected Health assemble () {
		return Health.builder()
				.withCurrentHitPoints(currentHitPointsBuffer)
				.withTemporaryHitPoints(temporaryHitPointsBuffer)
				.withMaximumHitPoints(target.maximumHitPoints())
				.build();
	}
}
