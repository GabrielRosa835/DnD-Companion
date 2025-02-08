package dnd_companion.actors.entities.system.unit.weight.data;

import dnd_companion.actors.entities.system.unit.weight.WeightUnitCentral;
import dnd_companion.actors.entities.system.unit.weight.WeightUnitEntity;

public final class Kilograms extends WeightUnitEntity
{
	public Kilograms() {
		super(WeightUnitCentral.use().builder()
				.name("Kilograms")
				.singularForm("Kilogram")
				.abbreviation("kg")
				.normalizingFactor(1)
				.build());
	}
}
