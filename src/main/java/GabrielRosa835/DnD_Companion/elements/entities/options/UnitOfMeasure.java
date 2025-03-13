package elements.entities.options;

import lombok.*;
import lombok.experimental.Accessors;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Getter
@Accessors(fluent = true)
public class UnitOfMeasure
{
	private String name;
	private String singularForm;
	private String abbreviation;
	private double normalizingFactor;

	public static class UnitOfLength extends UnitOfMeasure {
	}

	public static class UnitOfTime extends UnitOfMeasure {
	}

	public static class UnitOfCurrency extends UnitOfMeasure {
	}

	public static class UnitOfMass extends UnitOfMeasure {
	}
}
