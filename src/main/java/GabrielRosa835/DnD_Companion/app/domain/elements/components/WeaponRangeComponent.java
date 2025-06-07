package app.domain.elements.components;

import app.experimental.*;
import jakarta.persistence.*;
import lombok.*;

@Embeddable
@With
public record WeaponRangeComponent(
		@Embedded
		MeasureComponent normalRange,

		@Embedded
		MeasureComponent longRange
) {}
