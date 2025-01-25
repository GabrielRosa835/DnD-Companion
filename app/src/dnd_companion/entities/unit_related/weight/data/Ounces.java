package dnd_companion.entities.unit_related.weight.data;

import dnd_companion.entities.unit_related.weight.WeightUnitCentral;
import dnd_companion.entities.unit_related.weight.WeightUnitEntity;

public final class Ounces extends WeightUnitEntity
{
	public Ounces() {
		super(new WeightUnitCentral().builder()
				.name("Ounces")
				.singular("Ounce")
				.abbreviation("oz")
				.normalizing_factor(35.274)
				.build());
	}
}
