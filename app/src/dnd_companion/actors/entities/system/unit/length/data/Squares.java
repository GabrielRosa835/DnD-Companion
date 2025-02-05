package dnd_companion.actors.entities.system.unit.length.data;

import dnd_companion.actors.entities.system.unit.length.LengthUnitCentral;
import dnd_companion.actors.entities.system.unit.length.LengthUnitEntity;

public class Squares extends LengthUnitEntity
{
	public Squares() {
		super(new LengthUnitCentral().builder()
				.name("Squares")
				.singularForm("Square")
				.abbreviation("sq")
				.normalizingFactor(1.5)
				.build());
	}
}
