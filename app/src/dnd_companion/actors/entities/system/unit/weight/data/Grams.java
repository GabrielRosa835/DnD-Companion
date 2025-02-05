package dnd_companion.actors.entities.system.unit.weight.data;

import dnd_companion.actors.entities.system.unit.weight.WeightUnitCentral;
import dnd_companion.actors.entities.system.unit.weight.WeightUnitEntity;

public final class Grams extends WeightUnitEntity
{
	public Grams() {
		super(new WeightUnitCentral().builder()
				.name("Grams")
				.singularForm("Gram")
				.abbreviation("g")
				.normalizingFactor(1000)
				.build());
	}
}
