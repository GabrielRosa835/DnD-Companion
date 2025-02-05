package dnd_companion.actors.entities.item.item_tag;

import com.fasterxml.jackson.annotation.JsonProperty;

import dnd_companion.actors.models.Entity;
import dnd_companion.actors.models.EntityScheme;

public class ItemTagScheme implements EntityScheme
{
	@JsonProperty private String name;

	ItemTagScheme() {}

	@Override public ItemTagScheme loadEntity(Entity entity) {
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
