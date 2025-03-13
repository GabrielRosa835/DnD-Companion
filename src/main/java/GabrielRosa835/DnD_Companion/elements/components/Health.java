package elements.components;

import elements.entities.Character;
import lombok.*;
import lombok.experimental.*;
import tactics.Effect;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@Builder
@Accessors(fluent = true)
public class Health implements Effect.Applicable<Health>, Character.Property
{
	private Character character;

	private int currentHitPoints;
	private int maximumHitPoints;
	private int temporaryHitPoints;

	@Override public void applyEffect (Effect<Health> effect) {
		Health result = effect.applyTo(this);
		this.currentHitPoints = result.currentHitPoints;
		this.maximumHitPoints = result.maximumHitPoints;
		this.temporaryHitPoints = result.temporaryHitPoints;
	}
}