package dnd_companion.actors.entities.rules.condition.data;

import dnd_companion.actors.entities.rules.condition.ConditionCentral;
import dnd_companion.actors.entities.rules.condition.ConditionEntity;

public class Poisoned extends ConditionEntity
{
	public Poisoned() {
		super(ConditionCentral.use().builder()
				.name("Poisoned")
				.build());
	}
}
