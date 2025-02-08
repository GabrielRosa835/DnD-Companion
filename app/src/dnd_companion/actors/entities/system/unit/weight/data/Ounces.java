package dnd_companion.actors.entities.system.unit.weight.data;

import dnd_companion.actors.entities.system.unit.weight.WeightUnitCentral;
import dnd_companion.actors.entities.system.unit.weight.WeightUnitEntity;

public final class Ounces extends WeightUnitEntity
{
	public Ounces() {
		super(WeightUnitCentral.use().builder()
				.name("Ounces")
				.singularForm("Ounce")
				.abbreviation("oz")
				.normalizingFactor(35.274)
				.build());
	}
}
