package app.domain.elements.options;

import app.domain.elements.models.Option;

public record Alignment(
		String ID,
		String order,
		String moral
) implements Option {

	@Override public String name() {
		return order + " " + moral;
	}

}
