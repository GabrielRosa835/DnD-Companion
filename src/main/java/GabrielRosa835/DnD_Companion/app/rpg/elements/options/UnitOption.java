package app.rpg.elements.options;

import app.rpg.elements.models.Option;
import lombok.Builder;

@Builder(setterPrefix = "with")
public record UnitOption(
		String name,
		String singularForm,
		String abbreviation,
		double normalizingFactor,
		UnitTypeOption type
) implements Option {
	//
}
