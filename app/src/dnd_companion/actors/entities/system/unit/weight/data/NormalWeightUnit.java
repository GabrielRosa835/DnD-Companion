package dnd_companion.actors.entities.system.unit.weight.data;

import dnd_companion.actors.entities.system.unit.weight.WeightUnitCentral;
import dnd_companion.actors.entities.system.unit.weight.WeightUnitEntity;

public class NormalWeightUnit extends WeightUnitEntity
{
	public NormalWeightUnit() {
		super(WeightUnitCentral.use().builder().build());
	}
}
