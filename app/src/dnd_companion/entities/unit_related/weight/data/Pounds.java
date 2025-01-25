package dnd_companion.entities.unit_related.weight.data;

import dnd_companion.entities.unit_related.weight.WeightUnitCentral;
import dnd_companion.entities.unit_related.weight.WeightUnitEntity;

public final class Pounds extends WeightUnitEntity
{
	public Pounds() {
		super(new WeightUnitCentral().builder()
				.name("Pounds")
				.singular("Pound")
				.abbreviation("lbs")
				.normalizing_factor(2.20462)
				.build());
	}
}
