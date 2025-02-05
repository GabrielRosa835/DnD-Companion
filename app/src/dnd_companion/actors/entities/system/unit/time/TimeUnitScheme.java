package dnd_companion.actors.entities.system.unit.time;

import com.fasterxml.jackson.annotation.JsonProperty;

import dnd_companion.actors.models.Entity;
import dnd_companion.actors.models.EntityScheme;

public class TimeUnitScheme implements EntityScheme
{
	@JsonProperty private String name;
	@JsonProperty private String singularForm;
	@JsonProperty private String abbreviation;
	@JsonProperty private double normalizingFactor;

	TimeUnitScheme() {}

	@Override public TimeUnitScheme loadEntity(Entity entity) {
		TimeUnitEntity cast_entity = (TimeUnitEntity) entity;
		this.name = cast_entity.name();
		this.singularForm = cast_entity.singularForm();
		this.abbreviation = cast_entity.abbreviation();
		this.normalizingFactor = cast_entity.normalizingFactor();
		return this;
	}
	@Override public TimeUnitEntity retrieveEntity() {
		return new TimeUnitBuilder()
				.name(name)
				.singularForm(singularForm)
				.abbreviation(abbreviation)
				.normalizingFactor(normalizingFactor)
				.build();
	}
}
