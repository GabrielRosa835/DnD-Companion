package app.experimental;

import lombok.*;

@Builder (setterPrefix = "with", toBuilder = true)
public record MeasureComponent(
		Unit unit,
		float value
) {}
