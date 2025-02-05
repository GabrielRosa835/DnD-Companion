package dnd_companion.actors.entities.system.unit.time.data;

import dnd_companion.actors.entities.system.unit.time.TimeUnitCentral;
import dnd_companion.actors.entities.system.unit.time.TimeUnitEntity;

public class NormalTimeUnit extends TimeUnitEntity
{
	public NormalTimeUnit() {
		super(new TimeUnitCentral().builder().build());
	}
}
