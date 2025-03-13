package elements.entities.options;

import lombok.*;
import lombok.experimental.Accessors;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
@NoArgsConstructor (access = AccessLevel.PACKAGE)
@Builder (setterPrefix = "with")
@Accessors (fluent = true)
@ToString
@Getter
public class UnitOfMeasure
{
	private double normalizingFactor;
	private String singularForm;
	private String abbreviation;
	private String name;
	private Type type;

	public enum Type {
		LENGTH, TIME, CURRENCY, MASS;
	}
}
