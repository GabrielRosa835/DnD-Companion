package dnd_companion.entities.condition;

import dnd_companion.entities.models.EntityFactory;

public class ConditionFactory implements EntityFactory
{
	ConditionFactory() {}
	
	public ConditionEntity poisoned() {
		return new ConditionBuilder()
				.name("Poisoned")
				.description("Description :)")
				.build();
	}
	
	public ConditionEntity blinded() {
		return new ConditionBuilder()
				.name("Blinded")
				.description("Description :(")
				.build();
	}
}
