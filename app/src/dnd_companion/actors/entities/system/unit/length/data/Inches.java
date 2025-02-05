package dnd_companion.actors.entities.system.unit.length.data;

import dnd_companion.actors.entities.system.unit.length.LengthUnitCentral;
import dnd_companion.actors.entities.system.unit.length.LengthUnitEntity;

public class Inches extends LengthUnitEntity
{
	public Inches() {
		super(new LengthUnitCentral().builder()
				.name("Inches")
				.singularForm("Inch")
				.abbreviation("in")
				.normalizingFactor(39.3701)
				.build());
	}
}
