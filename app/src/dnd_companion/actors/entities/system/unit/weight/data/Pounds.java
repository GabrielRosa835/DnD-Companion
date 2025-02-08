package dnd_companion.actors.entities.system.unit.weight.data;

import dnd_companion.actors.entities.system.unit.weight.WeightUnitCentral;
import dnd_companion.actors.entities.system.unit.weight.WeightUnitEntity;

public final class Pounds extends WeightUnitEntity
{
	public Pounds() {
		super(WeightUnitCentral.use().builder()
				.name("Pounds")
				.singularForm("Pound")
				.abbreviation("lbs")
				.normalizingFactor(2.20462)
				.build());
	}
}
