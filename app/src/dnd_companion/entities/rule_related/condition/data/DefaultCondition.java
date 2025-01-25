package dnd_companion.entities.rule_related.condition.data;

import dnd_companion.entities.rule_related.condition.ConditionCentral;
import dnd_companion.entities.rule_related.condition.ConditionEntity;

public class DefaultCondition extends ConditionEntity
{
	public DefaultCondition() {
		super(new ConditionCentral().builder().build());
	}
}
