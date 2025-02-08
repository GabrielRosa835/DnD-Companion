package dnd_companion.actors.entities.system.unit.time.data;

import dnd_companion.actors.entities.system.unit.time.TimeUnitCentral;
import dnd_companion.actors.entities.system.unit.time.TimeUnitEntity;

public class Weeks extends TimeUnitEntity
{
	public Weeks() {
		super(TimeUnitCentral.use().builder()
				.name("Weeks")
				.singularForm("Week")
				.abbreviation("wk")
				.normalizingFactor(0.00595238)
				.build());
	}
}
