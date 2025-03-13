package elements.components;

import common.*;
import elements.entities.*;
import elements.models.*;
import lombok.*;
import lombok.experimental.Accessors;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@ToString
@Getter
@Accessors(fluent = true)
public class Measure<T extends UnitOfMeasure>
{
	private double value;
	private UnitOfMeasure unit;

	public static class Distance extends Measure<UnitOfMeasure.UnitOfLength> {
	}

	public static class Period extends Measure<UnitOfMeasure.UnitOfTime> {
	}

	public static class Price extends Measure<UnitOfMeasure.Currency> {
	}

	public static class Weight extends Measure<UnitOfMeasure.UnitOfMass> {
	}
}
