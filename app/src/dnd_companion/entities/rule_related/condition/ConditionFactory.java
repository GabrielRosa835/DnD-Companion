package dnd_companion.entities.rule_related.condition;

import java.util.Arrays;
import java.util.List;

import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.EntityFactory;

public class ConditionFactory implements EntityFactory
{
	ConditionFactory() {}
	
	@Override public List<Entity> dataList() {
		return Arrays.asList(poisoned(), blinded());
	}
	
	public ConditionEntity poisoned() {
		return new ConditionBuilder()
				.name("Poisoned")
				.build();
	}
	public ConditionEntity blinded() {
		return new ConditionBuilder()
				.name("Blinded")
				.build();
	}
}
