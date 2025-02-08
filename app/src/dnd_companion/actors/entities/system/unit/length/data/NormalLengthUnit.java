package dnd_companion.actors.entities.system.unit.length.data;

import dnd_companion.actors.entities.system.unit.length.LengthUnitCentral;
import dnd_companion.actors.entities.system.unit.length.LengthUnitEntity;

public class NormalLengthUnit extends LengthUnitEntity
{
	public NormalLengthUnit() {
		super(LengthUnitCentral.use().builder().build());
	}
}
