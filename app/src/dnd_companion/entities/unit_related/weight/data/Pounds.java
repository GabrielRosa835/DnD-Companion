package dnd_companion.entities.unit_related.weight.data;

import dnd_companion.entities.unit_related.weight.WeightUnitCentral;
import dnd_companion.entities.unit_related.weight.WeightUnitEntity;

public final class Pounds extends WeightUnitEntity
{
	public Pounds() {
		super(create());
	}
	private static Pounds create() {
		return (Pounds) new WeightUnitCentral().builder()
				.name("Pound")
				.plural("Pounds")
				.abbreviation("lbs")
				.normalizing_factor(2.20462)
				.build();
	}
}
