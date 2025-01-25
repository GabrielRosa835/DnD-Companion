package dnd_companion.entities.rule_related.condition.data;

import dnd_companion.entities.rule_related.condition.ConditionCentral;
import dnd_companion.entities.rule_related.condition.ConditionEntity;

public class Blinded extends ConditionEntity
{
	public Blinded() {
		super(new ConditionCentral().builder()
				.name("Blinded")
				.build());
	}
}
