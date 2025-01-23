package dnd_companion.entities.unit_related.weight.data;

import dnd_companion.entities.unit_related.weight.WeightUnitCentral;
import dnd_companion.entities.unit_related.weight.WeightUnitEntity;

public final class Kilograms extends WeightUnitEntity
{
	public Kilograms() {
		super(create());
	}
	private static Kilograms create() {
		return (Kilograms) new WeightUnitCentral().builder()
				.name("Kilogram")
				.plural("Kilograms")
				.abbreviation("kg")
				.normalizing_factor(1)
				.build();
	}
}
