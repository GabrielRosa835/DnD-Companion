package app.domain.elements.components;

import app.domain.elements.entities.options.system.*;
import jakarta.persistence.*;

import java.util.*;

@Embeddable
public record CharacterHealthComponent(
		@Embedded
		HealthComponent health,

		@ElementCollection (fetch = FetchType.EAGER)
		@Enumerated (EnumType.STRING)
		List<DeathSave> deathsaves,

		@Embedded
		DiceGroupComponent hitDice
) {
	public int maximumHitPoints() {
		return health.maximumHitPoints();
	}
	public int currentHitPoints() {
		return health.currentHitPoints();
	}
	public int temporaryHitPoints() {
		return health.temporaryHitPoints();
	}
}
