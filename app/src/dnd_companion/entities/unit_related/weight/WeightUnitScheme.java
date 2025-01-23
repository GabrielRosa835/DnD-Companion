package dnd_companion.entities.unit_related.weight;

import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.EntityScheme;

public class WeightUnitScheme implements EntityScheme 
{
	private String name;
	private String plural;
	private String abbreviation;
	private double normalizing_factor;
	
	WeightUnitScheme() {}
	
	@Override public WeightUnitScheme loadEntity(Entity entity) {
		WeightUnitEntity cast_entity = (WeightUnitEntity) entity;
		this.name = cast_entity.name;
		this.plural = cast_entity.plural;
		this.abbreviation = cast_entity.abbreviation;
		this.normalizing_factor = cast_entity.normalizing_factor;
		return this;
	}
	@Override public WeightUnitEntity retrieveEntity() {
		return new WeightUnitBuilder()
				.name(name)
				.plural(plural)
				.abbreviation(abbreviation)
				.normalizing_factor(normalizing_factor)
				.build();
	}
}
