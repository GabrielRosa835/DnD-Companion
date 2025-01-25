package dnd_companion.entities.unit_related.length.data;

import dnd_companion.entities.unit_related.length.LengthUnitCentral;
import dnd_companion.entities.unit_related.length.LengthUnitEntity;

public class Meters extends LengthUnitEntity
{
	public Meters() {
		super(create());
	}
	private static LengthUnitEntity create() {
		return new LengthUnitCentral().builder()
				.name("Meters")
				.singular("Meter")
				.abbreviation("m")
				.normalizing_factor(0)
				.build();
	}
}
