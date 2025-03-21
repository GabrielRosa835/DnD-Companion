package GabrielRosa835.dnd_companion.app.elements.components;

import GabrielRosa835.dnd_companion.app.elements.entities.character.Character;
import GabrielRosa835.dnd_companion.app.tactics.*;
import lombok.*;
import lombok.experimental.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Accessors(fluent = true)
@ToString
@Builder (setterPrefix = "with")
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