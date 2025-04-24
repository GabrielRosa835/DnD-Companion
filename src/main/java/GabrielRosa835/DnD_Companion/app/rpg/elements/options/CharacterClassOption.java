package app.rpg.elements.options;

import app.rpg.elements.models.Option;

public record CharacterClassOption(
		String name
) implements Option {
	// ARTIFICER, BARBARIAN, BARD, CLERIC,
	// DRUID, FIGHTER, MONK,
	// PALADIN, RANGER, ROGUE,
	// SORCERER, WARLOCK, WIZARD
}
