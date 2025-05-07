package app.domain.elements.options;

import app.domain.elements.models.Option;

public record WeaponMastery(
		String ID,
		String name,
		String description
) implements Option {
	// CLEAVE, GRAZE, NICK, PUSH, SAP, SLOW, TOPPLE, VEX
}
