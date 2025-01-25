package dnd_companion.entities.unit_related.time.data;

import dnd_companion.entities.unit_related.time.TimeUnitCentral;
import dnd_companion.entities.unit_related.time.TimeUnitEntity;

public class DefaultTimeUnit extends TimeUnitEntity
{
	public DefaultTimeUnit() {
		super(new TimeUnitCentral().builder().build());
	}
}
