package dnd_companion.entities.armor_related.armor_category;

import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.EntityScheme;

class ArmorCategoryScheme implements EntityScheme 
{
	private String name;
	private String description;
	
	ArmorCategoryScheme() {}
	
	@Override public ArmorCategoryScheme loadEntity(Entity entity) {
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
