package app.rpg.elements.options;

import app.rpg.elements.models.Option;

public record WeaponTypeOption(
		String name
) implements Option {
	// MELEE, RANGED
}
