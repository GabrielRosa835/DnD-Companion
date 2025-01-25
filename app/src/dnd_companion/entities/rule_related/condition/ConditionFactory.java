package dnd_companion.entities.rule_related.condition;

import java.util.Arrays;
import java.util.List;

import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.EntityFactory;
import dnd_companion.entities.rule_related.condition.data.Blinded;
import dnd_companion.entities.rule_related.condition.data.DefaultCondition;
import dnd_companion.entities.rule_related.condition.data.Poisoned;

public class ConditionFactory implements EntityFactory
{
	ConditionFactory() {}

	@Override public List<Entity> dataList() {
		return Arrays.asList(poisoned(), blinded());
	}
	@Override public Entity defaultData() {
		return new DefaultCondition();
	}

	public ConditionEntity poisoned() {
		return new Poisoned();
	}
	public ConditionEntity blinded() {
		return new Blinded();
	}
}
