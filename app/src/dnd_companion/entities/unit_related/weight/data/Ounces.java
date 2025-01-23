package dnd_companion.entities.unit_related.weight.data;

import dnd_companion.entities.unit_related.weight.WeightUnitCentral;
import dnd_companion.entities.unit_related.weight.WeightUnitEntity;

public final class Ounces extends WeightUnitEntity
{
	public Ounces() {
		super(create());
	}
	private static Ounces create() {
		return (Ounces) new WeightUnitCentral().builder()
				.name("Ounce")
				.plural("Ounces")
				.abbreviation("oz")
				.normalizing_factor(35.274)
				.build();
	}
}
