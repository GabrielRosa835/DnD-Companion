package dnd_companion.entities.item_related.item_tags;

import dnd_companion.entities.addons.models.Entity;
import dnd_companion.entities.addons.models.EntityScheme;

public class ItemTagScheme implements EntityScheme 
{
	private String name;
	
	ItemTagScheme() {}
	
	@Override public ItemTagScheme loadEntity(Entity entity) {
		ItemTagEntity cast_entity = (ItemTagEntity) entity;
		this.name = cast_entity.name;
		return this;
	}
	@Override public ItemTagEntity retrieveEntity() {
		return new ItemTagBuilder()
				.name(name)
				.build();
	}
}
