package app.domain.elements.options;

import app.domain.elements.models.*;

public record WeaponProperty(
		String ID,
		String name
) implements Option {}
