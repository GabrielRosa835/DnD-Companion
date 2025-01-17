package dnd_companion.entities.models;

import dnd_companion.common.design_patterns.Adapter;

public interface EntityScheme extends Adapter 
{
	public EntityScheme loadEntity(Entity entity);
	public Entity retrieveEntity();
}
