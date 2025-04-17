package app.rpg.elements.components;

import app.rpg.models.Component;
import lombok.*;
import lombok.experimental.Accessors;

@AllArgsConstructor (staticName = "create")
@Accessors (fluent = true)
@ToString
@Getter
public class HealthComponent
	implements Component<HealthComponent>
{
	private int temporaryHitPoints;
	private int currentHitPoints;
	private int maximumHitPoints;

	@Override public void update (HealthComponent clone) {
		this.temporaryHitPoints = clone.temporaryHitPoints;
		this.currentHitPoints = clone.currentHitPoints;
		this.maximumHitPoints = clone.maximumHitPoints;
	}
}