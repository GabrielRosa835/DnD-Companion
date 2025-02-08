package dnd_companion.actors.entities.system.unit.time.data;

import dnd_companion.actors.entities.system.unit.time.TimeUnitCentral;
import dnd_companion.actors.entities.system.unit.time.TimeUnitEntity;

public class Seconds extends TimeUnitEntity
{
	public Seconds() {
		super(TimeUnitCentral.use().builder()
				.name("Seconds")
				.singularForm("Second")
				.abbreviation("s")
				.normalizingFactor(3600)
				.build());
	}
}
