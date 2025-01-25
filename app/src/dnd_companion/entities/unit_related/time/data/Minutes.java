package dnd_companion.entities.unit_related.time.data;

import dnd_companion.entities.unit_related.time.TimeUnitCentral;
import dnd_companion.entities.unit_related.time.TimeUnitEntity;

public class Minutes extends TimeUnitEntity
{
	public Minutes() {
		super(new TimeUnitCentral().builder()
				.name("Minutes")
				.singular("Minute")
				.abbreviation("min")
				.normalizing_factor(60)
				.build());
	}
}
