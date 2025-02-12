package dnd_companion.actors.models;

import dnd_companion.common.BaseCollections;
import dnd_companion.common.design_patterns.Facade;
import dnd_companion.common.design_patterns.Singleton;

public interface IEntityCentral extends Facade, Singleton
{
	public IEntityBuilder builder();
	public IEntityScheme scheme();
	public BaseCollections collection();
	public String path(String entity_name);
	public IEntity retrieve(String entity_name);
	public IData[] data();
}
