package app.domain.elements.options;

import app.domain.elements.models.Option;

public record PlayerClass(
		String ID,
		String name
) implements Option {
	// ARTIFICER, BARBARIAN, BARD, CLERIC,
	// DRUID, FIGHTER, MONK,
	// PALADIN, RANGER, ROGUE,
	// SORCERER, WARLOCK, WIZARD
}
