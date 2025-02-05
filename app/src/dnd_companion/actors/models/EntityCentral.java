package dnd_companion.actors.models;

import dnd_companion.common.BaseCollections;
import dnd_companion.common.design_patterns.Facade;
import dnd_companion.common.design_patterns.Singleton;

public interface EntityCentral extends Facade, Singleton
{
	public EntityBuilder builder();
	public EntityScheme scheme();
	public BaseCollections collection();
	public String path(String entity_name);
	public Entity retrieve(String entity_name);
	public Entity[] data();
}
