package dnd_companion.actors.entities.rules.condition;

import com.fasterxml.jackson.annotation.JsonProperty;

import dnd_companion.actors.models.IEntity;
import dnd_companion.actors.models.IEntityScheme;

public class ConditionScheme implements IEntityScheme
{
	@JsonProperty private String name;
	@JsonProperty private String description;

	ConditionScheme() {}

	@Override public ConditionScheme loadEntity(IEntity entity) {
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
