package dnd_companion.entities.unit_related.time.data;

import dnd_companion.entities.unit_related.time.TimeUnitCentral;
import dnd_companion.entities.unit_related.time.TimeUnitEntity;

public class Days extends TimeUnitEntity
{
	public Days() {
		super(new TimeUnitCentral().builder()
				.name("Days")
				.singular("Day")
				.abbreviation("dd")
				.normalizing_factor(0.0416667)
				.build());
	}
}
