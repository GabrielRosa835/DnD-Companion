package dnd_companion.actors.entities.system.unit.time.data;

import dnd_companion.actors.entities.system.unit.time.TimeUnitCentral;
import dnd_companion.actors.entities.system.unit.time.TimeUnitEntity;

public class Days extends TimeUnitEntity
{
	public Days() {
		super(new TimeUnitCentral().builder()
				.name("Days")
				.singularForm("Day")
				.abbreviation("dd")
				.normalizingFactor(0.0416667)
				.build());
	}
}
