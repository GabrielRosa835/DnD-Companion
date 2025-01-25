package dnd_companion.entities.unit_related.length.data;

import dnd_companion.entities.unit_related.length.LengthUnitCentral;
import dnd_companion.entities.unit_related.length.LengthUnitEntity;

public class DefaultLengthUnit extends LengthUnitEntity
{
	public DefaultLengthUnit() {
		super(new LengthUnitCentral().builder().build());
	}
}
