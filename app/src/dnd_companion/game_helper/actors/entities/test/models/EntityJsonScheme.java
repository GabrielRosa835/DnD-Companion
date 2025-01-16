package dnd_companion.game_helper.actors.entities.test.models;

import dnd_companion.common.design_patterns.Adapter;

public interface EntityJsonScheme extends Adapter 
{
	public EntityJsonScheme loadEntity(Entity entity);
	public Entity retrieveEntity();
}
