package dnd_companion.entities.unit_related.length.data;

import dnd_companion.entities.unit_related.length.LengthUnitCentral;
import dnd_companion.entities.unit_related.length.LengthUnitEntity;

public class Inches extends LengthUnitEntity
{
	public Inches() {
		super(new LengthUnitCentral().builder()
				.name("Inches")
				.singular("Inch")
				.abbreviation("in")
				.normalizing_factor(39.3701)
				.build());
	}
}
