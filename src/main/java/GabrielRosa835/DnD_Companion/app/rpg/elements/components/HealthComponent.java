package app.rpg.elements.components;

import app.rpg.elements.models.Component;
import lombok.*;
import lombok.experimental.Accessors;

@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
@Accessors(fluent = true)
@ToString
@Getter
public class HealthComponent implements Component<HealthComponent>
{
	private int currentHitPoints;
	private int maximumHitPoints;
	private int temporaryHitPoints;

	@Override public HealthComponent update(HealthComponent clone) {
		this.temporaryHitPoints = clone.temporaryHitPoints;
		this.currentHitPoints = clone.currentHitPoints;
		this.maximumHitPoints = clone.maximumHitPoints;
		return this;
	}
	public HealthComponent replicate() {
		return new HealthComponent().update(this);
	}
}