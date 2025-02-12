package dnd_companion.actors.models;

import dnd_companion.common.design_patterns.Adapter;

public interface IEntityScheme extends Adapter
{
	public IEntityScheme loadEntity(IEntity entity);
	public IEntity retrieveEntity();
}
