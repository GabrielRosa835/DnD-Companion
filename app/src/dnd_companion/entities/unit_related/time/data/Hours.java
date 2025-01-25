package dnd_companion.entities.unit_related.time.data;

import dnd_companion.entities.unit_related.time.TimeUnitCentral;
import dnd_companion.entities.unit_related.time.TimeUnitEntity;

public class Hours extends TimeUnitEntity
{
	public Hours() {
		super(new TimeUnitCentral().builder()
				.name("Hours")
				.singular("Hour")
				.abbreviation("h")
				.normalizing_factor(1)
				.build());
	}
}
