package app.experimental;

import lombok.*;

@With
public record Unit(
		String id,
		String name,
		String singularForm,
		String abbreviation,
		double normalizingFactor,
		UnitType type
) implements Option {
}
