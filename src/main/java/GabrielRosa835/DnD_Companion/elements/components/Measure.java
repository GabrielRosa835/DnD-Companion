package elements.components;

import common.*;
import elements.entities.*;
import elements.models.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@ToString
@Getter
public class Measure<T extends UnitOfMeasure.Types> implements Component, Replicable {
	private double value;
	private UnitOfMeasure<T> unit;

	public Class<T> type() {
		return unit.getType();
	}

	@Override
	public Measure<T> replicate() {
		return new Measure<T>(value, unit.replicate());
	}

	public static class Distance extends Measure<UnitOfMeasure.Types.LENGTH> {
	}

	public static class Period extends Measure<UnitOfMeasure.Types.TIME> {
	}

	public static class Price extends Measure<UnitOfMeasure.Types.CURRENCY> {
	}

	public static class Weight extends Measure<UnitOfMeasure.Types.MASS> {
	}
}
