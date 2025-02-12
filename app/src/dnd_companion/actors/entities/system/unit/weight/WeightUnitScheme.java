package dnd_companion.actors.entities.system.unit.weight;

import com.fasterxml.jackson.annotation.JsonProperty;

import dnd_companion.actors.models.IEntity;
import dnd_companion.actors.models.IEntityScheme;

public class WeightUnitScheme implements IEntityScheme
{
	@JsonProperty private String name;
	@JsonProperty private String singularForm;
	@JsonProperty private String abbreviation;
	@JsonProperty private double normalizingFactor;

	WeightUnitScheme() {}

	@Override public WeightUnitScheme loadEntity(IEntity entity) {
		WeightUnitEntity cast_entity = (WeightUnitEntity) entity;
		this.name = cast_entity.name();
		this.singularForm = cast_entity.singularForm();
		this.abbreviation = cast_entity.abbreviation();
		this.normalizingFactor = cast_entity.normalizingFactor();
		return this;
	}
	@Override public WeightUnitEntity retrieveEntity() {
		return new WeightUnitBuilder()
				.name(name)
				.singularForm(singularForm)
				.abbreviation(abbreviation)
				.normalizingFactor(normalizingFactor)
				.build();
	}
}
