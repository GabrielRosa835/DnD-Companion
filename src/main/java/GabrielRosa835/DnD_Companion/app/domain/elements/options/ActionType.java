package app.domain.elements.options;

import app.domain.elements.models.Option;

public record ActionType(
		String ID,
		String name
) implements Option {
	// FULL_ACTION, BONUS_ACTION, REACTION, INSTANT, SPECIAL
}
