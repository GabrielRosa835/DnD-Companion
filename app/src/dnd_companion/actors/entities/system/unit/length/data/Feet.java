package dnd_companion.actors.entities.system.unit.length.data;

import dnd_companion.actors.entities.system.unit.length.LengthUnitCentral;
import dnd_companion.actors.entities.system.unit.length.LengthUnitEntity;

public class Feet extends LengthUnitEntity
{
	public Feet() {
		super(new LengthUnitCentral().builder()
				.name("Feet")
				.singularForm("Foot")
				.abbreviation("ft")
				.normalizingFactor(3.28084)
				.build());
	}
}
