package elements.components;

import elements.entities.Character;
import lombok.*;
import lombok.experimental.*;
import tactics.Effect;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@NoArgsConstructor (access = AccessLevel.PACKAGE)
@Builder (setterPrefix = "with")
@Accessors (fluent = true)
@ToString
@Getter
public class Health implements
		Effect.Applicable<Health>,
		Character.Property
{
	private Character character;

	private int temporaryHitPoints;
	private int currentHitPoints;
	private int maximumHitPoints;

	@Override
	public Health applyEffect (Effect<Health> effect) {
		var result = effect.applyTo(this);
		this.temporaryHitPoints = result.temporaryHitPoints;
		this.currentHitPoints = result.currentHitPoints;
		this.maximumHitPoints = result.maximumHitPoints;
		return this;
	}
}