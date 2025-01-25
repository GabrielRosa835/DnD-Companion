package dnd_companion.entities.rule_related.condition.data;

import dnd_companion.entities.rule_related.condition.ConditionCentral;
import dnd_companion.entities.rule_related.condition.ConditionEntity;

public class Poisoned extends ConditionEntity
{
	public Poisoned() {
		super(new ConditionCentral().builder()
				.name("Poisoned")
				.build());
	}
}
