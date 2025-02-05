package dnd_companion.actors.entities.system.unit.currency;

import com.fasterxml.jackson.annotation.JsonProperty;

import dnd_companion.actors.models.Entity;
import dnd_companion.actors.models.EntityScheme;

public class CurrencyUnitScheme implements EntityScheme
{
	@JsonProperty private String name;
	@JsonProperty private String singularForm;
	@JsonProperty private String abbreviation;
	@JsonProperty private double normalizingFactor;

	CurrencyUnitScheme() {}

	@Override public CurrencyUnitScheme loadEntity(Entity entity) {
		CurrencyUnitEntity cast_entity = (CurrencyUnitEntity) entity;
		this.name = cast_entity.name();
		this.singularForm = cast_entity.singularForm();
		this.abbreviation = cast_entity.abbreviation();
		this.normalizingFactor = cast_entity.normalizingFactor();
		return this;
	}
	@Override public CurrencyUnitEntity retrieveEntity() {
		return new CurrencyUnitBuilder()
				.name(name)
				.singularForm(singularForm)
				.abbreviation(abbreviation)
				.normalizingFactor(normalizingFactor)
				.build();
	}
}
