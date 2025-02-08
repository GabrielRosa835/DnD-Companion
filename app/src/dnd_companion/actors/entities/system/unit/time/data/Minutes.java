package dnd_companion.actors.entities.system.unit.time.data;

import dnd_companion.actors.entities.system.unit.time.TimeUnitCentral;
import dnd_companion.actors.entities.system.unit.time.TimeUnitEntity;

public class Minutes extends TimeUnitEntity
{
	public Minutes() {
		super(TimeUnitCentral.use().builder()
				.name("Minutes")
				.singularForm("Minute")
				.abbreviation("min")
				.normalizingFactor(60)
				.build());
	}
}
