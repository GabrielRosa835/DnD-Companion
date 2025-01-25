package dnd_companion.entities.unit_related.length.data;

import dnd_companion.entities.unit_related.length.LengthUnitCentral;
import dnd_companion.entities.unit_related.length.LengthUnitEntity;

public class Squares extends LengthUnitEntity
{
	public Squares() {
		super(new LengthUnitCentral().builder()
				.name("Squares")
				.singular("Square")
				.abbreviation("sq")
				.normalizing_factor(1.5)
				.build());
	}
}
