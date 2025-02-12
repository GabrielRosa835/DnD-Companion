package dnd_companion.actors.entities.armor.category;

import com.fasterxml.jackson.annotation.JsonProperty;

import dnd_companion.actors.models.IEntity;
import dnd_companion.actors.models.IEntityScheme;

class ArmorCategoryScheme implements IEntityScheme
{
	@JsonProperty private String name;
	@JsonProperty private String description;

	ArmorCategoryScheme() {}

	@Override public ArmorCategoryScheme loadEntity(IEntity entity) {
		ArmorCategoryEntity cast_entity = (ArmorCategoryEntity) entity;
		this.name = cast_entity.name();
		this.description = cast_entity.description();
		return this;
	}
	@Override public ArmorCategoryEntity retrieveEntity() {
		return new ArmorCategoryBuilder()
				.name(name)
				.description(description)
				.build();
	}
}
