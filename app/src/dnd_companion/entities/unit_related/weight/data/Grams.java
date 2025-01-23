package dnd_companion.entities.unit_related.weight.data;

import dnd_companion.entities.unit_related.weight.WeightUnitCentral;
import dnd_companion.entities.unit_related.weight.WeightUnitEntity;

public final class Grams extends WeightUnitEntity
{
	public Grams() {
		super(create());
	}
	private static Grams create() {
		return (Grams) new WeightUnitCentral().builder()
				.name("Gram")
				.plural("Grams")
				.abbreviation("g")
				.normalizing_factor(1000)
				.build();
	}
}
