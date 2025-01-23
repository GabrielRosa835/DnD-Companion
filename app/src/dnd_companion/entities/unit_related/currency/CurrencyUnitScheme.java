package dnd_companion.entities.unit_related.currency;

import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.EntityScheme;

public class CurrencyUnitScheme implements EntityScheme 
{
	private String name;
	private String plural;
	private String abbreviation;
	private double normalizing_factor;
	
	CurrencyUnitScheme() {}
	
	@Override public CurrencyUnitScheme loadEntity(Entity entity) {
		CurrencyUnitEntity cast_entity = (CurrencyUnitEntity) entity;
		this.name = cast_entity.name;
		this.plural = cast_entity.plural;
		this.abbreviation = cast_entity.abbreviation;
		this.normalizing_factor = cast_entity.normalizing_factor;
		return this;
	}
	@Override public CurrencyUnitEntity retrieveEntity() {
		return new CurrencyUnitBuilder()
				.name(name)
				.plural(plural)
				.abbreviation(abbreviation)
				.normalizing_factor(normalizing_factor)
				.build();
	}
}
