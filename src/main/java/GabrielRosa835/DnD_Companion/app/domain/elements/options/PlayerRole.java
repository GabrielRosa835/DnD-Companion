package app.domain.elements.options;

import app.domain.elements.models.*;

public record PlayerRole(
		String ID,
		String name
) implements Option {}
