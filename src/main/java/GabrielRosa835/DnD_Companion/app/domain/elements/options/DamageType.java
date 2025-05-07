package app.domain.elements.options;

import app.domain.elements.models.Option;

public record DamageType(
		String ID,
		String name
) implements Option {
	//
}
