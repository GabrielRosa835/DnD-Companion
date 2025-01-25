package dnd_companion.entities.unit_related.length.data;

import dnd_companion.entities.unit_related.length.LengthUnitCentral;
import dnd_companion.entities.unit_related.length.LengthUnitEntity;

public class Feet extends LengthUnitEntity
{
	public Feet() {
		super(new LengthUnitCentral().builder()
				.name("Feet")
				.singular("Foot")
				.abbreviation("ft")
				.normalizing_factor(3.28084)
				.build());
	}
}
