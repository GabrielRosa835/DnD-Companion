package dnd_companion.actors.entities.rules.condition.data;

import dnd_companion.actors.entities.rules.condition.ConditionCentral;
import dnd_companion.actors.entities.rules.condition.ConditionEntity;

public class Blinded extends ConditionEntity
{
	public Blinded() {
		super(ConditionCentral.use().builder()
				.name("Blinded")
				.build());
	}
}
