package dnd_companion.game_helper.actors.entities.test.condition;

import dnd_companion.game_helper.actors.entities.test.models.Entity;
import dnd_companion.game_helper.actors.entities.test.models.EntityJsonScheme;

public class ConditionJsonScheme implements EntityJsonScheme
{
	private String name;
	private String description;
	
	@Override public ConditionJsonScheme loadEntity(Entity entity) {
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
