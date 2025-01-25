package dnd_companion.entities.unit_related.length;

import com.fasterxml.jackson.annotation.JsonProperty;

import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.EntityScheme;

public class LengthUnitScheme implements EntityScheme
{
	@JsonProperty private String name;
	@JsonProperty private String singular;
	@JsonProperty private String abbreviation;
	@JsonProperty private double normalizing_factor;

	LengthUnitScheme() {}

	@Override public LengthUnitScheme loadEntity(Entity entity) {
		LengthUnitEntity cast_entity = (LengthUnitEntity) entity;
		this.name = cast_entity.name();
		this.singular = cast_entity.singular();
		this.abbreviation = cast_entity.abbreviation();
		this.normalizing_factor = cast_entity.normalizing_factor();
		return this;
	}
	@Override public LengthUnitEntity retrieveEntity() {
		return new LengthUnitBuilder()
				.name(name)
				.singular(singular)
				.abbreviation(abbreviation)
				.normalizing_factor(normalizing_factor)
				.build();
	}
}
