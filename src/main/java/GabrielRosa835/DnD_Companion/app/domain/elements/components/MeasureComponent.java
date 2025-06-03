package app.domain.elements.components;

import app.domain.elements.options.system.Unit;
import jakarta.persistence.*;
import lombok.*;

@Embeddable
@With
public record MeasureComponent (
	Unit unit,
	double value
) {}
