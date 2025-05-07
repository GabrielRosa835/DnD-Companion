package app.domain.effects;

import app.domain.elements.components.playerCharacter.*;

import java.util.*;

public interface PlayerClassEffects {
	static int calculateTotalLevel(Collection<PlayerClassComponent> classes) {
		return classes.stream()
				.map(PlayerClassComponent::level)
				.reduce(Integer::sum)
				.orElseThrow(() -> new RuntimeException("Couldn't get total level"));
	}
}
