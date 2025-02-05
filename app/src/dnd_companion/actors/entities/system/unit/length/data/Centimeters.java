package dnd_companion.actors.entities.system.unit.length.data;

import dnd_companion.actors.entities.system.unit.length.LengthUnitCentral;
import dnd_companion.actors.entities.system.unit.length.LengthUnitEntity;

public class Centimeters extends LengthUnitEntity
{
	public Centimeters() {
		super(new LengthUnitCentral().builder()
				.name("Centimeters")
				.singularForm("Centimeter")
				.abbreviation("cm")
				.normalizingFactor(100)
				.build());
	}
}
