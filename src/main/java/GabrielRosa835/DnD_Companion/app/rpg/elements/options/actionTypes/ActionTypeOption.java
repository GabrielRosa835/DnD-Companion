package app.rpg.elements.options.actionTypes;

import app.rpg.elements.models.Option;

public record ActionTypeOption(
		String name
) implements Option {
	// FULL_ACTION, BONUS_ACTION, REACTION, INSTANT, SPECIAL
}
