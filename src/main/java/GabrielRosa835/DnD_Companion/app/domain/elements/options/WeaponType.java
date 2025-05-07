package app.domain.elements.options;

import app.domain.elements.models.Option;

public record WeaponType(
		String ID,
		String name
) implements Option {}
