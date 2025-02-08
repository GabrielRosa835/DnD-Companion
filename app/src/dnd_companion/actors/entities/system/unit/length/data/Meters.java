package dnd_companion.actors.entities.system.unit.length.data;

import dnd_companion.actors.entities.system.unit.length.LengthUnitCentral;
import dnd_companion.actors.entities.system.unit.length.LengthUnitEntity;

public class Meters extends LengthUnitEntity
{
	public Meters() {
		super(LengthUnitCentral.use().builder()
				.name("Meters")
				.singularForm("Meter")
				.abbreviation("m")
				.normalizingFactor(0)
				.build());
	}
}
