package dnd_companion.entities.unit_related.weight.data;

import dnd_companion.entities.unit_related.weight.WeightUnitCentral;
import dnd_companion.entities.unit_related.weight.WeightUnitEntity;

public class DefaultWeightUnit extends WeightUnitEntity
{
	public DefaultWeightUnit() {
		super(new WeightUnitCentral().builder().build());
	}
}
