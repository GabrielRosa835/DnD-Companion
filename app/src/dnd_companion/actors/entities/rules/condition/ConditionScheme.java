package dnd_companion.actors.entities.rules.condition;

import com.fasterxml.jackson.annotation.JsonProperty;

import dnd_companion.actors.models.Entity;
import dnd_companion.actors.models.EntityScheme;

public class ConditionScheme implements EntityScheme
{
	@JsonProperty private String name;
	@JsonProperty private String description;

	ConditionScheme() {}

	@Override public ConditionScheme loadEntity(Entity entity) {
		ConditionEntity condition_entity = (ConditionEntity) entity;
		this.name = condition_entity.name();
		this.description = condition_entity.description();
		return this;
	}
	@Override public ConditionEntity retrieveEntity() {
		return new ConditionBuilder()
				.name(name)
				.description(description)
				.build();
	}
}
