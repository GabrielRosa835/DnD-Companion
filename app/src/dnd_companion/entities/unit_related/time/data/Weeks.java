package dnd_companion.entities.unit_related.time.data;

import dnd_companion.entities.unit_related.time.TimeUnitCentral;
import dnd_companion.entities.unit_related.time.TimeUnitEntity;

public class Weeks extends TimeUnitEntity
{
	public Weeks() {
		super(new TimeUnitCentral().builder()
				.name("Weeks")
				.singular("Week")
				.abbreviation("wk")
				.normalizing_factor(0.00595238)
				.build());
	}
}
