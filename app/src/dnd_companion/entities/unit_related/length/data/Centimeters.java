package dnd_companion.entities.unit_related.length.data;

import dnd_companion.entities.unit_related.length.LengthUnitCentral;
import dnd_companion.entities.unit_related.length.LengthUnitEntity;

public class Centimeters extends LengthUnitEntity
{
	public Centimeters() {
		super(new LengthUnitCentral().builder()
				.name("Centimeters")
				.singular("Centimeter")
				.abbreviation("cm")
				.normalizing_factor(100)
				.build());
	}
}
