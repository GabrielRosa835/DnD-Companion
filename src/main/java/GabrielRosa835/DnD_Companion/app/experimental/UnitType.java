package app.experimental;

import lombok.*;

@With
public record UnitType(
		String id,
		String name
) implements Option {
	// DISTANCE, WEIGHT, TIME, CURRENCY
}
