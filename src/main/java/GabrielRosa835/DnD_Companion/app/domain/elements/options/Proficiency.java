package app.domain.elements.options;

import app.domain.elements.models.*;

public record Proficiency(
		String ID,
		String name,
		double multiplier
) implements Option {

}
