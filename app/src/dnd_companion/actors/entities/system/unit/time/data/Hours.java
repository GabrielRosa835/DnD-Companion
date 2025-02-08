package dnd_companion.actors.entities.system.unit.time.data;

import dnd_companion.actors.entities.system.unit.time.TimeUnitCentral;
import dnd_companion.actors.entities.system.unit.time.TimeUnitEntity;

public class Hours extends TimeUnitEntity
{
	public Hours() {
		super(TimeUnitCentral.use().builder()
				.name("Hours")
				.singularForm("Hour")
				.abbreviation("h")
				.normalizingFactor(1)
				.build());
	}
}
