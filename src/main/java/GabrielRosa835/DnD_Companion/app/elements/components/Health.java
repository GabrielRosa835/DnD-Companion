package elements.components;

import behaviors.*;
import elements.entities.character.Character;
import lombok.*;
import lombok.experimental.*;

import java.util.Set;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@Accessors (fluent = true)
@ToString
@Builder (setterPrefix = "with")
@Getter
public class Health implements
		Effectable<Health>,
		Character.Property
{
	private Character character;

	private int temporaryHitPoints;
	private int currentHitPoints;
	private int maximumHitPoints;

	@Override public Health applyEffect (Effect<Health> effect, Set<Catalyst<?>> catalysts) {
		var result = effect.applyTo(this, catalysts);
		update(result);
		return this;
	}
	protected void update(Health clone) {
		this.temporaryHitPoints = clone.temporaryHitPoints;
		this.currentHitPoints = clone.currentHitPoints;
		this.maximumHitPoints = clone.maximumHitPoints;
	}
}