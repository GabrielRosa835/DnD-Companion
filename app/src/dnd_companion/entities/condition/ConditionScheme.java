package dnd_companion.entities.condition;

import dnd_companion.entities.models.Entity;
import dnd_companion.entities.models.EntityScheme;

public class ConditionScheme implements EntityScheme
{
	private String name;
	private String description;
	
	@Override public ConditionScheme loadEntity(Entity entity) {
		ConditionEntity condition_entity = (ConditionEntity) entity;
		this.name = condition_entity.name;
		this.description = condition_entity.description;
		return this;
	}
	@Override public ConditionEntity retrieveEntity() {
		return new ConditionBuilder()
				.name(name)
				.description(description)
				.build();
	}
}
