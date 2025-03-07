package elements.components;

import common.*;
import elements.models.*;
import lombok.*;
import lombok.experimental.*;
import tactics.*;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@Builder
@Accessors(fluent = true)
public class Health implements Component, Effect.Applicable, Replicable
{
	private int currentHitPoints;
	private int maximumHitPoints;
	private int temporaryHitPoints;

	@Override public Health applyEffect(tactics.Effect effect) {
		Effect e = (Effect) effect;
		e.loadObject(this).execute();
		this.currentHitPoints = e.changeCurrentHitPoints();
		this.maximumHitPoints = e.changeMaximumHitPoints();
		this.temporaryHitPoints = e.changeTemporaryHitPoints();
		return this;
	}

	public interface Effect extends tactics.Effect {
		int changeCurrentHitPoints();
		int changeMaximumHitPoints();
		int changeTemporaryHitPoints();
	}
}