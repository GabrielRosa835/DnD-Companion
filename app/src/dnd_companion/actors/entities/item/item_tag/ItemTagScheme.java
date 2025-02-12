package dnd_companion.actors.entities.item.item_tag;

import dnd_companion.actors.models.IEntity;
import dnd_companion.actors.models.IEntityScheme;

public class ItemTagScheme implements IEntityScheme
{
	private String name;

	ItemTagScheme() {}

	@Override public ItemTagScheme loadEntity(IEntity entity) {
		ItemTagEntity cast_entity = (ItemTagEntity) entity;
		this.name = cast_entity.name();
		return this;
	}
	@Override public ItemTagEntity retrieveEntity() {
		return new ItemTagBuilder()
				.name(name)
				.build();
	}
}
