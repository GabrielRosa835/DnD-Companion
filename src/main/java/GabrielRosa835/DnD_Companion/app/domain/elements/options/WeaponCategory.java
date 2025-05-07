package app.domain.elements.options;

import app.domain.elements.models.Option;

public record WeaponCategory(
		String ID,
		String name
) implements Option {
	// SIMPLE, MARTIAL
}
