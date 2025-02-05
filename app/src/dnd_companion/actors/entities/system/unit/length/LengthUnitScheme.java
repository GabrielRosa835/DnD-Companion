package dnd_companion.actors.entities.system.unit.length;

import com.fasterxml.jackson.annotation.JsonProperty;

import dnd_companion.actors.models.Entity;
import dnd_companion.actors.models.EntityScheme;

public class LengthUnitScheme implements EntityScheme
{
	@JsonProperty private String name;
	@JsonProperty private String singularForm;
	@JsonProperty private String abbreviation;
	@JsonProperty private double normalizingFactor;

	LengthUnitScheme() {}

	@Override public LengthUnitScheme loadEntity(Entity entity) {
		LengthUnitEntity cast_entity = (LengthUnitEntity) entity;
		this.name = cast_entity.name();
		this.singularForm = cast_entity.singularForm();
		this.abbreviation = cast_entity.abbreviation();
		this.normalizingFactor = cast_entity.normalizingFactor();
		return this;
	}
	@Override public LengthUnitEntity retrieveEntity() {
		return new LengthUnitBuilder()
				.name(name)
				.singularForm(singularForm)
				.abbreviation(abbreviation)
				.normalizingFactor(normalizingFactor)
				.build();
	}
}
