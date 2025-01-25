package dnd_companion.entities.unit_related.time.data;

import dnd_companion.entities.unit_related.time.TimeUnitCentral;
import dnd_companion.entities.unit_related.time.TimeUnitEntity;

public class Seconds extends TimeUnitEntity
{
	public Seconds() {
		super(new TimeUnitCentral().builder()
				.name("Seconds")
				.singular("Second")
				.abbreviation("s")
				.normalizing_factor(3600)
				.build());
	}
}
