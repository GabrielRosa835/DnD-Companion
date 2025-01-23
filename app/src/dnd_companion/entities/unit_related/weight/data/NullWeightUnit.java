package dnd_companion.entities.unit_related.weight.data;

import dnd_companion.entities.unit_related.weight.WeightUnitCentral;
import dnd_companion.entities.unit_related.weight.WeightUnitEntity;

public final class NullWeightUnit extends WeightUnitEntity
{
	public NullWeightUnit() {
		super(create());
	}
	private static NullWeightUnit create() {
		return (NullWeightUnit) new WeightUnitCentral().builder()
				.name("None")
				.plural("None")
				.abbreviation("none")
				.normalizing_factor(0)
				.build();
	}
}
