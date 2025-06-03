package app.domain.effects;

import app.domain.elements.components.*;

import java.util.*;

public interface PlayerClassEffects {
	static int calculateTotalLevel(Collection<CompositePlayerClassComponent> classes) {
		return classes.stream()
				.map(CompositePlayerClassComponent::level)
				.reduce(Integer::sum)
				.orElseThrow(() -> new RuntimeException("Couldn't get total level"));
	}
}
