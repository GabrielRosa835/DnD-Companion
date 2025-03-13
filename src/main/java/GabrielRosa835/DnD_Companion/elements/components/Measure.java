package elements.components;

import common.*;
import elements.entities.options.*;
import lombok.*;
import lombok.experimental.Accessors;
import tactics.*;

@NoArgsConstructor (access = AccessLevel.PACKAGE)
@Builder (setterPrefix = "with")
@Accessors (fluent = true)
@ToString
@Getter
public class Measure implements
		Effect.Applicable<Measure>,
		Replicable
{
	private UnitOfMeasure unit;
	private double value;
	private Type type;

	private Measure(UnitOfMeasure unit, double value, Type type) {
		if(!type.unitType().equals(unit.type())) {
			throw new IllegalArgumentException("Unit disparity in Measure creation");
		}
		this.type = type;
		this.value = value;
		this.unit = unit;
	}

	@Override
	public Measure applyEffect(Effect<Measure> effect) {
		var result = effect.applyTo(this);
		this.value = result.value;
		this.type = result.type;
		this.unit = result.unit;
		return this;
	}

	@RequiredArgsConstructor
	@Getter
	@Accessors(fluent = true)
	public enum Type {
		DISTANCE(UnitOfMeasure.Type.LENGTH),
		PERIOD(UnitOfMeasure.Type.TIME),
		PRICE(UnitOfMeasure.Type.CURRENCY),
		WEIGHT(UnitOfMeasure.Type.MASS);

		private final UnitOfMeasure.Type unitType;
	}
}
