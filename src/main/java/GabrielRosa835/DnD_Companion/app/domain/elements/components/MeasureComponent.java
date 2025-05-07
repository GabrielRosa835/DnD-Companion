package app.domain.elements.components;

import app.experimental.Unit;
import lombok.*;

@With
public record MeasureComponent (
	Unit unit,
	double value
) {}
